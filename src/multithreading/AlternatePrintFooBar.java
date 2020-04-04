package multithreading;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 17:38 4/4/2020
 * @Modified by:
 */
public class AlternatePrintFooBar {
    private int n;
    private final static Object lock = new Object();
    private boolean fooTurn = true;

    public AlternatePrintFooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (!fooTurn) lock.wait();
                fooTurn = false;
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (fooTurn) lock.wait();
                fooTurn = true;
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                lock.notifyAll();
            }
        }
    }
}















