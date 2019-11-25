package divide_and_conquer;

/**
 * @Author: Wenhang Chen
 * @Description:实现 int sqrt(int x)函数。计算并返回 x 的平方根，其中 x 是非负整数。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * @Date: Created in 16:01 11/14/2019
 * @Modified by:
 */
public class SqrtOfX {
    public int mySqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;

        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            if (mid * mid > x)
                right = mid - 1;
            else
                left = mid;
        }
        return (int) left;

    }
}
