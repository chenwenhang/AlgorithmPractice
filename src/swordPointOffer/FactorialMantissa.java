package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:设计一个算法，算出 n 阶乘有多少个尾随零。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * @Date: Created in 9:36 5/1/2020
 * @Modified by:
 */
public class FactorialMantissa {
//    n!中的零全部是5和2的倍数贡献的，由于因子为2的个数大于5的，所以，只需计算其中有多少个5的倍数即可。
    public int trailingZeroes(int n) {
        int m5 = 0;
        while (n > 0) {
            n /= 5;
            m5 += n;
        }
        return m5;
    }
}

















