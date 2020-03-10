package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。 示例：
 * <p>
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @Date: Created in 10:38 3/10/2020
 * @Modified by:
 */
public class ContiguousSequenceLCCI {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int max_value = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max_value = Math.max(max_value, dp[i]);
        }
        return max_value;
    }
}























