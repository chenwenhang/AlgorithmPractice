package multithreading;

/**
 * @Author: Wenhang Chen
 * @Description:交替打印ABC，synchronized实现
 * @Date: Created in 16:31 4/4/2020
 * @Modified by:
 */
public class AlternatePrintABCS {
    private final static Object lock = new Object();
    private static int state = 0;

    static class Task implements Runnable {
        private int num;
        private String name;

        public Task(String name, int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public void run() {
            int i = 0;
            while (i < 5) {
                synchronized (lock) {
                    while (state % 3 != num) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(this.name);
                    state++;
                    i++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Task("A", 0)).start();
        new Thread(new Task("B", 1)).start();
        new Thread(new Task("C", 2)).start();
    }

}




















