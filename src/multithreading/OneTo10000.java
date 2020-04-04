package multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Wenhang Chen
 * @Description:十个线程求1到10000的和
 * @Date: Created in 17:00 4/4/2020
 * @Modified by:
 */
public class OneTo10000 {
    // 每个线程计算 index ~ index+1000，存到数组的第 j 个位置上
    private static int[] sum = new int[10];

    static class Task implements Runnable {
        int index;
        int j;
        CountDownLatch latch;

        // CountDownLatch作为参数传入
        public Task(int index, int j, CountDownLatch latch) {
            this.index = index;
            this.j = j;
            this.latch = latch;
        }

        @Override
        public void run() {
            for (int i = index; i < index + 1000; i++) {
                sum[j] += i;
            }
            // 加好后countDown
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + "，" + index + "到" + (index + 999) + "和为：" + sum[j]);
        }
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Task(i * 1000 + 1, i, latch)).start();
        }
        try {
            // 等到latch为0的时候代表计算完毕
            latch.await();
            int res = 0;
            for (int num : sum) {
                res += num;
            }
            System.out.println("sum is " + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}















