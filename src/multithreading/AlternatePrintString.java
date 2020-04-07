package multithreading;

/**
 * @Author: Wenhang Chen
 * @Description:编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 假设有这么一个类：
 * <p>
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 * @Date: Created in 8:45 4/7/2020
 * @Modified by:
 */
public class AlternatePrintString {
    private static int state = 1;
    private static final Object lock = new Object();

    static class Task1 implements Runnable {
        private int max_value;

        public Task1(int max_value) {
            this.max_value = max_value;
        }

        @Override
        public void run() {
            while (state <= max_value) {
                synchronized (lock) {
                    while ((state % 3 != 0 || state % 5 != 0) && state <= max_value) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (state <= max_value) {
                        System.out.println("fizzbuzz");
                        state++;
                    }
                    lock.notifyAll();
                }
            }
        }
    }

    static class Task2 implements Runnable {
        private int max_value;

        public Task2(int max_value) {
            this.max_value = max_value;
        }

        @Override
        public void run() {
            while (state <= max_value) {
                synchronized (lock) {
                    while ((state % 3 != 0 || state % 5 == 0) && state <= max_value) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (state <= max_value) {
                        System.out.println("fizz");
                        state++;
                    }
                    lock.notifyAll();
                }
            }
        }
    }

    static class Task3 implements Runnable {
        private int max_value;

        public Task3(int max_value) {
            this.max_value = max_value;
        }

        @Override
        public void run() {
            while (state <= max_value) {
                synchronized (lock) {
                    while ((state % 3 == 0 || state % 5 != 0) && state <= max_value) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (state <= max_value) {
                        System.out.println("buzz");
                        state++;
                    }
                    lock.notifyAll();
                }
            }
        }
    }

    static class Task4 implements Runnable {
        private int max_value;

        public Task4(int max_value) {
            this.max_value = max_value;
        }

        @Override
        public void run() {
            while (state <= max_value) {
                synchronized (lock) {
                    while ((state % 3 == 0 || state % 5 == 0) && state <= max_value) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (state <= max_value) {
                        System.out.println(state);
                        state++;
                    }
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 15;
        new Thread(new Task1(n)).start();
        new Thread(new Task2(n)).start();
        new Thread(new Task3(n)).start();
        new Thread(new Task4(n)).start();
    }

}



















