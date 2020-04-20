package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。  
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 11
 * @Date: Created in 10:19 4/20/2020
 * @Modified by:
 */
public class TheNumberOfNsieves {
    public double[] twoSum(int n) {
        //思路二：动态规划（人人为我）
        /*
            子问题：
            状态：二维表 dp[n][6*n]：第n个筛子的“当前和”的出现次数
            转移方程：dp[n][j]=dp[n][j-1]+dp[n][j-2]+...+dp[n][j-6]
        */
        int[][] dp = new int[n][6 * n];
        for (int j = 0; j < 6; ++j) {
            dp[0][j] = 1;
        } //初始状态
        for (int i = 1; i < n; ++i) { //处理行
            for (int j = i; j < (i + 1) * 6; ++j) {
                for (int dice = 1; dice < 7; ++dice) {
                    if (j - dice < 0) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - dice];
                }
            }
        }
        double[] res = new double[5 * n + 1];
        int j = n - 1;
        for (int i = 0; i < res.length; ++i) {
            res[i] = dp[n - 1][j++] / Math.pow(6, n);
        }
        return res;
    }
}























