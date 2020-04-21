package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *  
 * <p>
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * @Date: Created in 10:54 4/21/2020
 * @Modified by:
 */
public class IntegerPowOfNumber {
    // 快速幂（二进制法）
    // n = 9 即 n = (1001)b
    // n = 1*b1 + 2*b2 + 4*b3 + ...
    // x = ...
    public double myPow(double x, int n) {
        double sum = 1;
        long t = n;
        if (t < 0) {
            x = 1 / x;
            t = -t;
        }
        while (t > 0) {
            long b = t & 1;
            sum *= b == 1 ? x : 1;
            x *= x;
            t >>= 1;
        }
        return sum;
    }
}























