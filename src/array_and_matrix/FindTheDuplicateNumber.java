package array_and_matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * @Date: Created in 15:47 1/23/2020
 * @Modified by:
 */
public class FindTheDuplicateNumber {
    // 面试中估计想不到别的
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            // 检查是否在集合中
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }

}






















