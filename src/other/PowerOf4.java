package other;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 16
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * @Date: Created in 23:51 6/18/2020
 * @Modified by:
 */
public class PowerOf4 {
    public boolean isPowerOfFour(int num) {
        while ((num != 0) && (num % 4 == 0)) {
            num /= 4;
        }
        return num == 1;
    }
}
