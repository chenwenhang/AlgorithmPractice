package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个非负整数数组，你最初位于数组的第一个位置。 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * @Date: Created in 9:45 1/14/2020
 * @Modified by:
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) return true;
        int end = nums.length - 1;
        // 起初将目的位置和当前位置都设置为数组的最后一个位置
        // 从后往前遍历，用当前位置的值减去 当前位置与目的位置的距离
        // 如果大于等于0代表当前位置能跳到目的位置，则将当前位置设置为目的位置
        // 否则继续往前遍历，寻找符合要求的位置
        // 直到目的位置为起点跳出
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = nums[i] - (end - i);
            if (nums[i] >= 0) {
                end = i;
            }
        }
        return end == 0;
    }
}













