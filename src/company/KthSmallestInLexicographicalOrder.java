package company;

/**
 * @Author: Wenhang Chen
 * @Description:给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。 注意：1 ≤ k ≤ n ≤ 109。
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * n: 13   k: 2
 * <p>
 * 输出:
 * 10
 * <p>
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * @Date: Created in 10:28 2/4/2020
 * @Modified by:
 */
public class KthSmallestInLexicographicalOrder {
    // 过程中要用long，int中途会溢出
    // 获取以数字prefix开头且不超过n的数字的个数
    long get_count(long prefix, long n) {
        long cnt = 0;
        // 每次累加上前缀为prefix到prefix+1的区间的所有数，每次添加后数字都要乘以10
        for (long a = prefix, b = prefix + 1; a <= n; a *= 10, b *= 10) {
            cnt += Math.min(n + 1, b) - a;
        }
        return cnt;
    }

    int findKthNumber(int n, int k) {
        long prefix = 1;
        // 用于存储位置
        long position = 1;
        // 如果还没到第k个数
        while (position < k) {
            // 获取当前前缀下的数字个数
            long cnt = get_count(prefix, n);
            // 如果当前位置加上当前前缀下的数字个数仍然小于k，则更新当前位置
            if (position + cnt <= k) {
                prefix++;
                position += cnt;
                // 如果更新后大于k，说明目标数就在当前前缀下，那么让当前前缀更加精确
                // 即增加一位后继续循环。类似于前缀树脂继续往下走
            } else if (position + cnt > k) {
                prefix *= 10;
                position++;
            }
        }
        return (int) prefix;
    }

}

















