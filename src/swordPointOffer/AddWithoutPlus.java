package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @Date: Created in 9:29 4/24/2020
 * @Modified by:
 */
public class AddWithoutPlus {
//    首先我们不考虑进位将两个二进制相加 1101 + 1000 = 0101 这个操作与(1101 异或 1000)的出来的值相同
//    从上一步中我们可以得出，进位为1，且在第3位（从右往左数）进1位 => 1000 << 1 = 10000
//    之后将 10000 + 0101 = 10101 => 21 此时进位位0，即可退出。
    public int add(int a, int b) {
        while (b != 0) {
            int sum = (a ^ b);
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }

}
