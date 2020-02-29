package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个未经排序的整数数组，找到最长且连续的的递增序列。 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * @Date: Created in 10:40 2/29/2020
 * @Modified by:
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return 1;
        int maxLen = 1;
        int curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 1;
            }
        }
        return maxLen;
    }
}



















