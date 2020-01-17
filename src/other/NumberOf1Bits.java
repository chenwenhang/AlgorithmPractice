package other;

/**
 * @Author: Wenhang Chen
 * @Description:编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * @Date: Created in 10:08 1/15/2020
 * @Modified by:
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            //1.  & ^ | 优先级小于 + -
            //2.  n和n-1与运算能把n中最低位的1变成0，其他位保持不变。
            count = count + (n & 1);
            n = n >> 1;
        }
        return count;
    }
}


















