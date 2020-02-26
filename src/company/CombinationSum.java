package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * @Date: Created in 9:49 2/26/2020
 * @Modified by:
 */
public class CombinationSum {
    // 回溯 + 剪枝
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(0, candidates, new ArrayList<>(), target, 0);
        return res;
    }

    public void helper(int sum, int[] array, List<Integer> solution, int target, int start) {
        if (sum > target) return;
        if (sum == target) {
            // 注意引用传递问题
            res.add(new ArrayList<>(solution));
            return;
        }
        for (int i = start; i < array.length; i++) {
            solution.add(array[i]);
            sum += array[i];
            helper(sum, array, solution, target, i);
            // 添加后需要删除
            solution.remove(solution.size() - 1);
            sum -= array[i];
        }
    }
}
























