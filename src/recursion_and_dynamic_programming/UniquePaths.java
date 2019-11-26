package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * @Date: Created in 10:12 11/26/2019
 * @Modified by:
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // dp[i]表示起点到当前格子有多少种走法
        int[][] dp = new int[m][n];
        // 初始化
        int i = 0, j = 0;
        for (i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 开始dp
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3, 2));
    }
}
