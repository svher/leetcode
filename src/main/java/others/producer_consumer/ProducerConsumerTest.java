package others.producer_consumer;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerTest {

    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private final BoundedQueue<Integer> queue;
    private final CyclicBarrier barrier;
    private final int nTrials, nPairs;
    private final AtomicLong putSum = new AtomicLong(0L), takeSum = new AtomicLong(0L);

    public static void main(String[] args) {
        new ProducerConsumerTest(10, 100, 5).test();
        pool.shutdown();
    }

    ProducerConsumerTest(int npairs, int nTrails, int capacity) {
        barrier = new CyclicBarrier(2 * npairs + 1);
        queue = new BoundedQueue<>(capacity);
        this.nTrials = nTrails;
        this.nPairs = npairs;
    }

    void test() {
        try {
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer(i));
                pool.execute(new Consumer(i));
            }
            barrier.await();
            barrier.await();
            System.out.printf("putSum:\t\t%d\ntakeSum:\t%d\n", putSum.get(), takeSum.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class BoundedQueue<T> {
        private final Lock lock = new ReentrantLock();
        private final Condition notFull = lock.newCondition();
        private final Condition notEmpty = lock.newCondition();
        private final T[] items;
        private int tail, head, count;

        @SuppressWarnings("unchecked")
        public BoundedQueue(int capacity) {
            items = (T[]) new Object[capacity];
        }

        public void put(T x) throws InterruptedException {
            lock.lock();
            try {
                while (count == items.length) {
                    notFull.await();
                }
                items[tail] = x;
                if (++tail == items.length) {
                    tail = 0;
                }
                ++count;
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        public T take() throws InterruptedException {
            lock.lock();
            try {
                while (count == 0) {
                    notEmpty.await();
                }
                T x = items[head];
                items[head] = null;
                if (++head == items.length) {
                    head = 0;
                }
                --count;
                notFull.signal();
                return x;
            } finally {
                lock.unlock();
            }
        }
    }

    static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;

    }

    class Producer implements Runnable {

        private final int tag;

        public Producer(int tag) {
            this.tag = tag;
        }

        @SneakyThrows
        @Override
        public void run() {
            int seed = (this.hashCode() ^ (int)System.nanoTime());
            long sum = 0;
            barrier.await();
            for (int i = 0; i < nTrials; i++) {
                queue.put(seed);
                sum += seed;
                seed = xorShift(seed);
            }
            putSum.getAndAdd(sum);
            System.out.printf("Producer %d completed\n", tag);
            barrier.await();
        }
    }

    class Consumer implements Runnable {

        private final int tag;

        public Consumer(int tag) {
            this.tag = tag;
        }

        @SneakyThrows
        @Override
        public void run() {
            barrier.await();
            long sum = 0;
            for (int i = nTrials; i > 0; i--) {
                sum += queue.take();
            }
            takeSum.getAndAdd(sum);
            System.out.printf("Consumer %d completed\n", tag);
            barrier.await();
        }
    }
}
