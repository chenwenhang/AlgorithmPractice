package multithreading;

/**
 * @Author: Wenhang Chen
 * @Description:生产者消费者
 * @Date: Created in 17:00 4/4/2020
 * @Modified by:
 */
public class BoundedBufferProblem {
    // 当前值
    private static int num = 0;
    // 临界值
    private final static int FULL = 10;
    // 锁
    private final static Object lock = new Object();

    static class Producer implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (i < 5) {
                synchronized (lock) {
                    // 先写不满足的时候wait住
                    while (num == FULL) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 满足的时候处理并且notifyAll
                    num++;
                    i++;
                    System.out.println(Thread.currentThread().getName() + " is producing");
                    lock.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (i < 5) {
                synchronized (lock) {
                    while (num == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num--;
                    i++;
                    System.out.println(Thread.currentThread().getName() + " is consuming");
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}
