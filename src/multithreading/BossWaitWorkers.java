package multithreading;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Wenhang Chen
 * @Description:老板等员工干活,CountDownLatch
 * @Date: Created in 16:43 4/4/2020
 * @Modified by:
 */
public class BossWaitWorkers {
    static class Worker implements Runnable {
        String name;
        CountDownLatch latch;

        // CountDownLatch作为参数传进来
        public Worker(String name, CountDownLatch latch) {
            this.latch = latch;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " is working");
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(3));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + " has completed task");
            // countDown让latch减一
            this.latch.countDown();
        }
    }

    static class Boss implements Runnable {
        CountDownLatch latch;

        public Boss(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Boss is waiting");
            try {
                // 注意这里等待是await，不是wait
                this.latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Boss start check");
        }
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);

        // CountDownLatch也作为参数传入
        new Thread(new Worker("Echo", latch)).start();
        new Thread(new Worker("Derrick", latch)).start();
        new Thread(new Worker("Stephen", latch)).start();
        new Thread(new Worker("Betty", latch)).start();

        new Thread(new Boss(latch)).start();

    }
}














