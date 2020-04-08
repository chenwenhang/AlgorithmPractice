package multithreading;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 15:07 4/7/2020
 * @Modified by:
 */
public class HRAndInterviewer {
    private static final Object lock = new Object();
    private static final int ALL = 1000;
    private static final int FULL = 100;
    private static  int num = 0;
    private static  int count = 0;


    // HR
    static class HR implements Runnable{
        @Override
        public void run(){
            while(count<ALL){
                try{
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(lock){
                    while(num==FULL){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num++;
                    count++;
                    System.out.println("HR处理简历");
                    lock.notifyAll();
                }
            }
        }

    }

    // 面试官A
    static class InterviewA implements Runnable{
        @Override
        public void run(){
            while(count<ALL){
                try{
                    TimeUnit.SECONDS.sleep(3);
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(lock){
                    while(num==0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num--;
                    int flag = new Random().nextInt(1);
                    if (flag == 1) System.out.println("面试官A处理简历 成功");
                    if (flag == 0) System.out.println("面试官A处理简历 失败");
                    lock.notifyAll();
                }
            }
        }

    }

    // 面试官B
    static class InterviewB implements Runnable{
        @Override
        public void run(){
            while(count<ALL){
                try{
                    TimeUnit.SECONDS.sleep(3);
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(lock){
                    while(num==0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num--;
                    int flag = new Random().nextInt(1);
                    if (flag == 1) System.out.println("面试官B处理简历 成功");
                    if (flag == 0) System.out.println("面试官B处理简历 失败");
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args){
        new Thread(new HR()).start();
        new Thread(new InterviewA()).start();
        new Thread(new InterviewB()).start();

    }





}
