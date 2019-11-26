package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @Date: Created in 10:38 11/26/2019
 * @Modified by:
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) return res;
        int len = nums.length;
        int k = (int) Math.pow(2, len);
        for (int i = 0; i < k; i++) {
            List<Integer> numList = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                // 位运算存储信息很有效
                if ((i >> j & 1) == 1)
                    numList.add(nums[j]);
            }
            res.add(numList);
        }
        return res;
    }
}
