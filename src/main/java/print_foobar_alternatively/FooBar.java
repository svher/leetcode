package print_foobar_alternatively;

public interface FooBar {
    void foo(Runnable printFoo) throws InterruptedException;

    void bar(Runnable printBar) throws InterruptedException;
}
