package other;

import java.util.Arrays;

/**
 * @Author: Wenhang Chen
 * @Description:统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @Date: Created in 20:21 1/19/2020
 * @Modified by:
 */
public class CountPrimes {
    public boolean isPrime(int n) {
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                // 有其他整除因子
                return false;
        return true;
    }

    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }
}
