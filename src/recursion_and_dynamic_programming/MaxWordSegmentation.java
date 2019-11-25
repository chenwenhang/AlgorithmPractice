package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:在自然语言处理中一个重要的问题是分词，例如句子“他说的确实在理”中“的确”“确实”“实在”“在理”都是常见的词汇，但是计算机必须为给定的句子准确判断出正确分词方法。一个简化的分词问题如下：给定一个长字符串y=y1y2…yn，分词是把y切分成若干连续部分，每部分都单独成为词汇。我们用函数quality(x)判断切分后的某词汇x=x1x2…xk的质量，函数值越高表示该词汇的正确性越高。分词的好坏用所有词汇的质量的和来表示。例如对句子“确实在理”分词，quality(确实)+quality(在理)>quality(确)+quality(实在)+quality(理)。请设计一个动态规划算法对字符串y分词，要求最大化所有词汇的质量和。（假定你可以调用quality(x)函数在一步内得到任何长度的词汇的质量）
 * @Date: Created in 9:46 11/4/2019
 * @Modified by:
 */
/*
 * 记：dp[i][j]为i到j的最大词汇质量
 * 状态转移方程：dp[i][j] = Math.max(dp[i][j], dp[i][k] + quality(k + 1, j));
 */
public class MaxWordSegmentation {
    // 象征性定义一个quality
    private int quality(int i, int j) {
        // (数据类型)(最小值+Math.random()*(最大值-最小值+1))
        return (int) (1 + Math.random() * (i - j + 1));
    }

    int getMaxValue(String[] word) {
        int n = word.length;
        int[][] dp = new int[n + 1][n + 1];
        // 初始化dp[i][i]
        for (int i = 1; i <= n; i++)
            dp[i][i] = quality(i, i);
        // 开始dp
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k < j; k++) {
                dp[1][j] = Math.max(dp[1][j], dp[1][k] + quality(k + 1, j));
            }
        }
        return dp[1][n];
    }
}
