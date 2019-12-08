package other;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * @Date: Created in 10:24 12/8/2019
 * @Modified by:
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // n 二进制最高位为 1，其余所有位为 0
        // n - 1 二进制最高位为 0，其余所有位为 1
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo pt = new PowerOfTwo();
        pt.isPowerOfTwo(1);
    }
}
