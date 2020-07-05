package recursion_and_dynamic_programming;

import java.util.LinkedList;

/**
 * @Author: Wenhang Chen
 * @Description:你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 2, b = [3]
 * 输出: 8
 * 示例 2:
 * <p>
 * 输入: a = 2, b = [1,0]
 * 输出: 1024
 * @Date: Created in 9:01 7/5/2020
 * @Modified by:
 */
public class SuperPower {
    static int mod = 1337;

    int superPow(int n, int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int e : nums)
            list.add(e);

        return myPow(n, list);
    }

    private int myPow(int n, LinkedList<Integer> list) {
        if (list.size() == 0)
            return 1;
        Integer last = list.removeLast();
        n = n % mod;
        int part1 = quickPow(n, last);
        int part2 = quickPow(myPow(n, list), 10);
        return (part1 * part2) % mod;
    }

    private int quickPow(int n, Integer k) {

        int res = 1;
        int temp = n % mod;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = (res * temp) % mod;
            }
            temp = (temp * temp) % mod;
            k = k >> 1;
        }
        return res % mod;
    }

}






















