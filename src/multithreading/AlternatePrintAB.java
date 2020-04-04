package multithreading;

/**
 * @Author: Wenhang Chen
 * @Description:交替打印AB，synchronized实现
 * @Date: Created in 15:11 4/4/2020
 * @Modified by:
 */
public class AlternatePrintAB {
    // 写一个锁
    private final static Object lock = new Object();
    // 一个状态标记
    private static boolean state = true;

    static class Task implements Runnable {
        private String name;
        private boolean flag;

        // 初始化
        public Task(String name, boolean flag) {
            this.name = name;
            this.flag = flag;
        }

        @Override
        public void run() {
            int i = 0;
            while (i < 5) {
                // 锁住代码块
                synchronized (lock) {
                    // 先写不满足的情况，等待
                    while (flag != state) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 再写满足的情况，注意更新状态，并唤醒其他线程
                    state = !state;
                    System.out.println(name);
                    lock.notifyAll();
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task("A", true));
        Thread t2 = new Thread(new Task("B", false));
        t1.start();
        t2.start();
    }
}
