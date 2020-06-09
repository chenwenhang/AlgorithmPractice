package other;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。 
 * <p>
 * 如果没有两个连续的 1，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：22
 * 输出：2
 * 解释：
 * 22 的二进制是 0b10110 。
 * 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
 * 第一对连续的 1 中，两个 1 之间的距离为 2 。
 * 第二对连续的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 * 示例 2：
 * <p>
 * 输入：5
 * 输出：2
 * 解释：
 * 5 的二进制是 0b101 。
 * 示例 3：
 * <p>
 * 输入：6
 * 输出：1
 * 解释：
 * 6 的二进制是 0b110 。
 * 示例 4：
 * <p>
 * 输入：8
 * 输出：0
 * 解释：
 * 8 的二进制是 0b1000 。
 * 在 8 的二进制表示中没有连续的 1，所以返回 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * @Date: Created in 21:06 6/9/2020
 * @Modified by:
 */
public class BinaryDistance {
    public int binaryGap(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) != 0)
                A[t++] = i;

        int ans = 0;
        for (int i = 0; i < t - 1; ++i)
            ans = Math.max(ans, A[i + 1] - A[i]);
        return ans;
    }
}




















