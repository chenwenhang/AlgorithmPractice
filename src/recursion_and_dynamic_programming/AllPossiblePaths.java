package recursion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 21:58 7/31/2020
 * @Modified by:
 */
public class AllPossiblePaths {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return solve(graph, 0);
    }

    public List<List<Integer>> solve(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (node == N - 1) {
            List<Integer> path = new ArrayList<>();
            path.add(N - 1);
            ans.add(path);
            return ans;
        }

        for (int nei : graph[node]) {
            // fox循环还能这么用
            for (List<Integer> path : solve(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }
}
