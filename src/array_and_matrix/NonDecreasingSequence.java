package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，总满足 array[i] <= array[i + 1]。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 * <p>
 * 说明：
 * <p>
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 * @Date: Created in 9:34 5/24/2020
 * @Modified by:
 */
public class NonDecreasingSequence {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (count == 1) {
                    return false;
                }
                if (i == 0) {
                    nums[i] = nums[i + 1] - 1;
                    count++;
                    continue;
                }
                if (pd(nums[i - 1], nums[i + 1])) {
                    count++;
                    nums[i] = nums[i - 1];
                } else {
                    count++;
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }

    public boolean pd(int a, int b) {//判断i-1 与 i+1大小{
        if (a > b) {
            return false;
        } else {
            return true;
        }
    }
}





















