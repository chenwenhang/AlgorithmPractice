package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * @Date: Created in 16:28 6/1/2020
 * @Modified by:
 */
public class MaximumCountOfConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int maxCnt = 0;
        int curCnt = 0;
        for (int num : nums) {
            if (num == 1) {
                curCnt++;
                maxCnt = Math.max(maxCnt, curCnt);
            } else if (num == 0) {
                curCnt = 0;
            }
        }
        return maxCnt;
    }
}




















