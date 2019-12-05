package array_and_matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个整数数组，判断是否存在重复元素。 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * @Date: Created in 9:46 12/5/2019
 * @Modified by:
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) return false;
//        Set<Integer> set = new HashSet<>();
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

}



















