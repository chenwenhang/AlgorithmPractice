package array_and_matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个未排序的整数数组，找出其中没有出现的最小的正整数。 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * @Date: Created in 9:27 2/3/2020
 * @Modified by:
 */
public class FirstMissingPositive {
    // 想不出原地算法，直接HashMap
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) return 1;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (num <= 0) {
                map.put(0, true);
            } else {
                map.put(num, true);
            }
        }
        int idx = 1;
        while (true) {
            if (!map.containsKey(idx)) {
                return idx;
            }
            idx++;
        }
    }
}























