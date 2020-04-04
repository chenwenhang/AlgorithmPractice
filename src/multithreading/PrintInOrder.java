package multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Wenhang Chen
 * @Description:我们提供了一个类： public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 * @Date: Created in 14:57 4/4/2020
 * @Modified by:
 */
public class PrintInOrder {
//    countDownLatch这个类使一个线程等待其他线程各自执行完毕后再执行。
//    通过一个计数器来实现，计数器的初始值是线程的数量。
//    每当一个线程执行完毕后，计数器的值就-1，
//    当计数器的值为0时，表示所有线程都执行完毕，
//    然后在闭锁上等待的线程就可以恢复工作了。

    private CountDownLatch c2;
    private CountDownLatch c3;

    public PrintInOrder() {
        c2 = new CountDownLatch(1);
        c3 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
//        .countDown（解释：使当前计数器减一）
        c2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
//        .await（解释：如果当前计数器不为0，那么挂起，等待 计数器为0后继续执行）
        c2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        c3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        c3.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}






















