package array_and_matrix;

import java.util.*;

/**
 * @Author: Wenhang Chen
 * @Description:有 N 个网络节点，标记为 1 到 N。 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 * <p>
 * <p>
 * 示例：
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * 输出：2
 * @Date: Created in 8:43 7/11/2020
 * @Modified by:
 */
public class NetworkDelayTime {
    Map<Integer, Integer> dist;

    public int networkDelayTime(int[][] times, int N, int K) {
        // 用HashMap存储图
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }
        for (int node : graph.keySet()) {
            graph.get(node).sort((a, b) -> a[0] - b[0]);
        }
        dist = new HashMap<>();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);

        dfs(graph, K, 0);
        int ans = 0;
        for (int cand : dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }

//    dist[node] 记录的是信号最早到达 node 的时间。当我们访问 node 时，
//    若经过了传递时间这个信号是最早到达该节点的，则我们广播这个信号
//    为了加快速度，在访问每个节点时，若传递该信号的时间比已有信号到达的时间长，则我们退出该信号
    public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
        if (elapsed >= dist.get(node)) return;
        dist.put(node, elapsed);
        if (graph.containsKey(node))
            for (int[] info : graph.get(node))
                dfs(graph, info[1], elapsed + info[0]);
    }
}






















