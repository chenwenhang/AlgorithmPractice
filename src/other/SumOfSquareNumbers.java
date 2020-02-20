package other;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * <p>
 * 示例1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: 3
 * 输出: False
 * @Date: Created in 11:14 2/20/2020
 * @Modified by:
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        // 双指针
        int a = 0;
        int b = (int) (c * 0.5) + 1;
        int res = a * a + b * b;
        while (a <= b) {
            if (res == c) return true;
            else if (res < c) a++;
            else b--;
            res = a * a + b * b;
        }
        return false;
    }
}



















