package others.aqs;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class OneShotLatch {

    private final Sync sync = new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected int tryAcquireShared(int arg) {
            // 1 open otherwise fail
            return (getState() == 1) ? 1 : 0;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1); // latch is now open
            return true;
        }
    }
}
