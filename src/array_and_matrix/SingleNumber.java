package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @Date: Created in 11:53 11/29/2019
 * @Modified by:
 */
public class SingleNumber {
    // a ^ 0 = a
    // a ^ a = 0
    // 异或满足交换律和结合律
    // a ^ b ^ a = a ^ a ^ b = 0 ^ b = b
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int flag = nums[0];
        for (int i = 1; i < nums.length; i++) {
            flag ^= nums[i];
        }
        return flag;
    }
}




















