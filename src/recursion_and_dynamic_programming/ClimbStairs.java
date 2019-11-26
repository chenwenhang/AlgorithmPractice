package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @Date: Created in 10:27 11/26/2019
 * @Modified by:
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 2; i < n; i++) {
            c = b;
            b += a;
            a = c;
        }
        return b;
    }
}















