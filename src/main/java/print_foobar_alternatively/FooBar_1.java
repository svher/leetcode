package print_foobar_alternatively;

public class FooBar_1 implements FooBar {

    private int flag = 0;
    private int n;

    public FooBar_1(int n) {
        this.n = n;
    }

    @Override
    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag == 1) {
                wait();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = 1;
            notifyAll();
        }
    }

    @Override
    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag == 0) {
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = 0;
            notifyAll();
        }
    }
}
