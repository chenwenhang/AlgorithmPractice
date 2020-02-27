package company;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * @Date: Created in 9:22 2/27/2020
 * @Modified by:
 */
public class Combinations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(1, new ArrayList<>(), n, k);
        return res;
    }

    public void helper(int num, List<Integer> solution, int n, int k) {
        if (solution.size() == k) {
            res.add(new ArrayList<>(solution));
        }
        if (num > n) {
            return;
        }
        for (int i = num; i <= n; i++) {
            solution.add(i);
            helper(i + 1, solution, n, k);
            solution.remove(solution.size() - 1);
        }
    }
}





















