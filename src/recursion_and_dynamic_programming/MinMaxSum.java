package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:给定一长度为N的整数序列(a1,a2,…,aN)，将其划分成多个子序列（此问题中子序列是连续的一段整数），满足每个子序列中整数的和不大于一个数B，设计一种划分方法，最小化所有子序列中最大值的和
 * @Date: Created in 14:54 11/3/2019
 * @Modified by:
 */
/*
 * 记：dp[i][j]为num[i]到num[j]的最小化所有子序列中最大值的和
 * 把他看成num[i]到num[k] 和 num[k+1]到num[j]两部分，前面一部分是已经算出来的最小化所有子序列中最大值的和，
 * 后面一部分看成一个整体，直接求其最大值。求出来后两者相加，与最初的dp[i][j]相比，取小值。（dp的初始化见下面代码注释）
 * 状态转移方程：dp[i][j] = min(dp[i][j], dp[i][k] + max[k + 1][j])，同时要保证sum[k + 1][j] <= B
 * */
public class MinMaxSum {
    static int getMinMaxSum(int[] a, int B) {
        int n = a.length;
        int[] num = new int[a.length + 1];
        // 本题使用了二维数组，实际上没必要，一位数组即可，这里为了顺便看看任意一段的结果
        // 定义二维数组便于输出任意一段的结果
        int[][] dp = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1]; // sum[i][j]存储num[i]到num[j]的和
        int[][] max = new int[n + 1][n + 1]; // max[i][j]存储num[i]到num[j]的最大值
        System.arraycopy(a, 0, num, 1, n);
        // 初始化sum和max数组
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                max[i][j] = num[i];
                for (int s = i; s <= j; s++) {
                    sum[i][j] += num[s];
                    max[i][j] = Math.max(max[i][j], num[s]);
                }
            }
        }
        // 初始化dp数组为num[i]到num[j]之和（显然如果这样做符合要求的话那一定是最小的），
        // 若不满足条件则初始化为无穷大
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = sum[i][j] <= B ? max[i][j] : Integer.MAX_VALUE;
            }
        }
        // 开始dp
        // 这里多了一层循环，可以删掉。相当于算出了任意一段的最小化所有子序列中最大值的和
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = i; k < j; k++) {
                    // 若符合条件，则更新
                    if (sum[k + 1][j] <= B) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + max[k + 1][j]);
                    }
                }
            }
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(String.format("%15d", max[i][j]));
//            }
//            System.out.println();
//        }
//
//        System.out.println();

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(String.format("%15d", dp[i][j]));
//            }
//            System.out.println();
//        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] num = {2, 2, 2, 8, 1, 8, 2, 1};
        System.out.println(getMinMaxSum(num, 17));
    }
}
