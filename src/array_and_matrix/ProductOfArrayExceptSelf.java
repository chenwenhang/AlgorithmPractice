package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * @Date: Created in 14:15 12/17/2019
 * @Modified by:
 */
public class ProductOfArrayExceptSelf {
    // 乘积 = 当前数左边的乘积 * 当前数右边的乘积
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }
}
