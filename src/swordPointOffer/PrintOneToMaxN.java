package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * @Date: Created in 9:22 3/27/2020
 * @Modified by:
 */
public class PrintOneToMaxN {
//    这题啥意义。。。
    public int[] printNumbers(int n) {
        int boundary = (int) (Math.pow(10, n));
        int[] nums = new int[boundary - 1];
        for (int i = 0; i < boundary - 1; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}




















