/**
 * @Author: Wenhang Chen
 * @Description:给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @Date: Created in 12:18 11/24/2019
 * @Modified by:
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        // dp表示以当前下标为结尾的最大子数组之和
        // dp[i] = dp[i - 1] >= 0 ? dp[i - 1] + dp[i] : dp[i];
        int[] dp = new int[nums.length];
        System.arraycopy(nums, 0, dp, 0, nums.length);
        int maxNum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] >= 0 ? dp[i - 1] + dp[i] : dp[i];
            maxNum = Math.max(maxNum, dp[i]);
        }
        return maxNum;
    }
}
