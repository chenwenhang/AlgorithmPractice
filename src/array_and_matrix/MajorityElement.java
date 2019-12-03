package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @Date: Created in 9:58 12/3/2019
 * @Modified by:
 */
public class MajorityElement {
    // Boyer-Moore 投票算法
    // 维护一个计数器，如果遇到一个我们目前的候选众数，就将计数器加一，否则减一。
    // 只要计数器等于 0 ，就将 nums 中之前访问的数字全部忘记，并把下一个数字当做候选的众数
    public int majorityElement(int[] nums) {
//        if (nums == null || nums.length < 1) return 0;
        int count = 1;
        int majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                if (count == 0) {
                    majority = nums[i];
                } else {
                    count--;
                }
            }
        }
        return majority;
    }
}

















