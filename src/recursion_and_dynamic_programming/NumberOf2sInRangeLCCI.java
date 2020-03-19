package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 * <p>
 * 示例:
 * <p>
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 * 提示：
 * <p>
 * n <= 10^9
 * @Date: Created in 9:28 3/19/2020
 * @Modified by:
 */
public class NumberOf2sInRangeLCCI {
    public int numberOf2sInRange(int n) {
        int bak = n;
        int num;
        int count = 0;
        int i = 0;//循环次数
        while (n > 0) {
            num = n % 10;
            n /= 10;
            if (num > 2) {
                count += (n + 1) * Math.pow(10, i);
            } else if (num == 2) {
                if (i > 0) {
                    count += n * Math.pow(10, i) + (bak % Math.pow(10, i) + 1);
                } else {
                    count += n * Math.pow(10, i) + 1;
                }
            } else {
                count += n * Math.pow(10, i);
            }
            i++;
        }
        return count;
    }
}
