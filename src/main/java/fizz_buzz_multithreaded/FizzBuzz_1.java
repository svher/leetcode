package fizz_buzz_multithreaded;

import java.util.function.IntConsumer;

public class FizzBuzz_1 implements FizzBuzz {

    private int n;
    private int cur;

    public FizzBuzz_1(int n) {
        this.n = n;
        this.cur = 1;
    }

    // printFizz.run() outputs "fizz".
    @Override
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (cur <= n) {
            if ((cur % 3) != 0 || (cur % 5) == 0) {
                wait();
                continue;
            }
            printFizz.run();
            cur++;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    @Override
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (cur <= n) {
            if ((cur % 3) == 0 || (cur % 5) != 0) {
                wait();
                continue;
            }
            printBuzz.run();
            cur++;
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    @Override
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (cur <= n) {
            if ((cur % 3) != 0 || (cur % 5) != 0) {
                wait();
                continue;
            }
            printFizzBuzz.run();
            cur++;
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    @Override
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (cur <= n) {
            if ((cur % 3) == 0 || (cur % 5) == 0) {
                wait();
                continue;
            }
            printNumber.accept(cur);
            cur++;
            notifyAll();
        }
    }
}
