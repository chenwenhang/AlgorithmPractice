package multithreading;
// 注意这两个juc包

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Wenhang Chen
 * @Description:交替打印ABC，ReentrantLock实现
 * @Date: Created in 15:52 4/4/2020
 * @Modified by:
 */
public class AlternatePrintABCR {
    // 注意ReentrantLock初始化方式
    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    static class Task implements Runnable {
        int num;
        String name;

        public Task(String name, int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public void run() {
            // 注意这里for循环中没有i++
            for (int i = 0; i < 10; ) {
                // 固定格式，try中lock，finally中unlock
                try {
                    lock.lock();
                    // 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                    while (state % 3 == num) {
                        System.out.println(this.name);
                        state++;
                        //变量自增必须写在这
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task("A", 0));
        Thread t2 = new Thread(new Task("B", 1));
        Thread t3 = new Thread(new Task("C", 2));
        t1.start();
        t2.start();
        t3.start();
    }
}
