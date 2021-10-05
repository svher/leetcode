package fizz_buzz_multithreaded;

import java.util.function.IntConsumer;

public interface FizzBuzz {
    // printFizz.run() outputs "fizz".
    void fizz(Runnable printFizz) throws InterruptedException;

    // printBuzz.run() outputs "buzz".
    void buzz(Runnable printBuzz) throws InterruptedException;

    // printFizzBuzz.run() outputs "fizzbuzz".
    void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException;

    // printNumber.accept(x) outputs "x", where x is an integer.
    void number(IntConsumer printNumber) throws InterruptedException;
}
