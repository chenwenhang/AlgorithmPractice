package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:给出N个1-9的数字(v1,v2,…,vN)，不改变它们的相对位置，在中间加入K个乘号和N-K-1个加号，（括号随便加）使最终结果尽量大。因为乘号和加号一共就是N-1个了，所以恰好每两个相邻数字之间都有一个符号。
 * @Date: Created in 10:48 11/3/2019
 * @Modified by:
 */
/*
 * 首先：对于1~9的数字，
 * 记： f(n,c) 为前n个数有c个乘号时的最大值
 * 现对乘号个数进行动态规划：
 * 假设将前k个数中有c-1个乘号，空位k处为第c个乘号，剩下的第k+1到第n个数全为加号
 * 状态转移方程：f(n,c)=f(k,c-1)*sum(k+1,n)
 * 注：该方程基于“当在[1,9]取值时，除了部分特例（例如全1相加大于相乘）以外，和的积大于积的和”，这里不再证明
 */
public class GetMaxEquation {
    int getMaxResult(int[] a, int n, int k) {
        int[] num = new int[a.length + 1];
        int[][] dp = new int[n + 1][k + 1];// dp数组，初始化多一位同样是为了便于dp进行
        int[][] sum = new int[n + 1][n + 1];// sum[i][j]存储num[i]到num[j]的和
        if (n >= 0) System.arraycopy(a, 0, num, 1, n);
        // 计算num[i]到num[j]的和，同时初始化num数组
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int s = i; s <= j; s++)
                    sum[i][j] += num[s];
            }
        }
        // 先计算全为 + 的情况，初始化dp[i][0]为sum[1][i]
        for (int i = 1; i <= n; i++)
            dp[i][0] = sum[1][i];
        for (int j = 1; j <= k; j++) {
            for (int i = j + 1; i <= n; i++) {
                // j<=s<=i，因为至少需要j个数才能产生j-1个空位
                // 数字个数一定多于乘号个数，所以此处外层为乘号个数循环
                // 内层为数字个数循环
                for (int s = j; s < i; s++)
                    // 最后乘以num[s+1]到num[i]的和
                    dp[i][j] = Math.max(dp[i][j], dp[s][j - 1] * sum[s + 1][i]);
            }
        }
        return dp[n][k];
    }
}
