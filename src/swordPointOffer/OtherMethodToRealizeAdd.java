package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 10:26 4/10/2020
 * @Modified by:
 */
public class OtherMethodToRealizeAdd {
//    1）分析上面对二进制的计算过程，不难发现：
//        1.计算不进位的和，相当于对两个数进制异或：1101^1001=0100；
//        2.计算进位，第1位相当于对两个数求与：1101&1001=1001，然后再对其进行左移1位：1001<<1=10010。
//    然后再重复以上两个步骤。这里再异或一次就得到结果了，没进位：0100^10010=10110=22。
//
//    2）计算a+b，等价于(a^b)+((a&b)<<1)。
//    由于公式中又出现了+号，因此要再重复2）这个等价的计算过程。
//    结束条件是：没有进位了。
    public int add(int a, int b) {
        while (b != 0) {
            int plus = (a ^ b); // 求和（不计进位）. 相同位置0，相反位置1
            b = ((a & b) << 1); // 计算进位. 先保留同为1的位，都为1的位要向左进位，因此左移1位
            a = plus;
        }
        return a;
    }
}
