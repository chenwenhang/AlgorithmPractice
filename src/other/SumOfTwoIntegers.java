package other;

/**
 * @Author: Wenhang Chen
 * @Description:不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 * @Date: Created in 20:42 1/6/2020
 * @Modified by:
 */
public class SumOfTwoIntegers {
//    a + b 的问题拆分为 (a 和 b 的无进位结果) + (a 和 b 的进位结果)
//    无进位加法使用异或运算计算得出
//    进位结果使用与运算和移位运算计算得出
//    循环此过程，直到进位为 0
    public int getSum(int a, int b) {
//        定理一：设a，b为两个二进制数，则a+b = a^b + (a&b)<<1
//        证明：a^b是不考虑进位时加法结果。当二进制位同时为1时，才有进位，
//              因此 (a&b)<<1是进位产生的值，称为进位补偿。将两者相加便是完整加法结果

        while (b != 0) {
            // a和b的进位结果
            int res = (a & b) << 1;
            // a和b的无进位结果
            a = a ^ b; // 0001 1001
            b = res;// 1000  0000
        }
        return a;
    }
}






