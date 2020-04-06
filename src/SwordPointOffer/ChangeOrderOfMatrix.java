package SwordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * @Date: Created in 8:54 4/6/2020
 * @Modified by:
 */
public class ChangeOrderOfMatrix {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length < 1) return nums;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 != 0) start++;
            while (start < end && nums[end] % 2 == 0) end--;
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
        }
        return nums;
    }
}



















