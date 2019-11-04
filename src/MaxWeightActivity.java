import java.util.Arrays;

/**
 * @Author: Wenhang Chen
 * @Description:给定𝑛个活动，活动𝑎_𝑖表示为一个三元组(𝑠_𝑖,𝑓_𝑖,𝑣_𝑖)，其中𝑠_𝑖表示活动开始时间，𝑓_𝑖表示活动的结束时间，𝑣_𝑖表示活动的权重。带权活动选择问题是选择一些活动，使得任意被选择的两个活动𝑎_𝑖和𝑎_𝑗执行时间互不相交，即区间[𝑠_𝑖,𝑓_𝑖]与[𝑠_𝑗,𝑓_𝑗]互不重叠，并且被选择的活动的权重和最大。请设计一种方法求解带权活动选择问题。
 * @Date: Created in 10:33 11/4/2019
 * @Modified by:
 */

/*
 * 记：dp[i]表示最后一个活动为第i个活动时候的总权值
 * 状态转移方程： dp[i] = Math.max(dp[i], dp[j] + activity[i][2]);
 */
public class MaxWeightActivity {
    int getMaxWeight(int[][] act) {
        int n = act.length;
        int[] dp = new int[n + 1];
        int[][] activity = new int[n + 1][3];
        // activity[i][0]表示开始时间
        // activity[i][1]表示结束时间
        // activity[i][2]表示活动权重
        for (int i = 0; i < n; i++) {
            activity[i + 1][0] = act[i][0];
            activity[i + 1][1] = act[i][1];
            activity[i + 1][2] = act[i][2];
        }
        // 活动按照结束时间排序
        Arrays.sort(activity, (o1, o2) -> o1[1] - o2[1]); // lambda Java 8
        // 初始化dp为当前任务
        for (int i = 1; i <= n; i++) {
            dp[i] = activity[i][2];
        }
        // 开始dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 如果目标活动在当前活动开始前结束，则符合要求
                if (activity[i][0] >= activity[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + activity[i][2]);
                }
            }
        }
        // 返回最大结果
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            maxValue = Math.max(dp[i], maxValue);
        }
        return maxValue;
    }
}
