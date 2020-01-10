package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * @Date: Created in 10:17 1/10/2020
 * @Modified by:
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum ^= i;
            sum ^= nums[i];
        }
        return sum;
    }
}





















