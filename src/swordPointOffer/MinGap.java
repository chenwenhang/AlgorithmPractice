package swordPointOffer;

import java.util.Arrays;

/**
 * @Author: Wenhang Chen
 * @Description:给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差 示例：
 * <p>
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出： 3，即数值对(11, 8)
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间[-2147483648, 2147483647]内
 * @Date: Created in 8:16 4/25/2020
 * @Modified by:
 */
public class MinGap {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        long res = Long.MAX_VALUE;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                res = Math.min(res, (long) b[j] - (long) a[i]);
                i++;
            } else {
                res = Math.min(res, (long) a[i] - (long) b[j]);
                j++;
            }
        }
        return (int) res;
    }
}
