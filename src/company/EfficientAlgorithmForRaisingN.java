package company;

/**
 * @Author: Wenhang Chen
 * @Description:求n次方的高效算法
 * @Date: Created in 9:15 2/12/2020
 * @Modified by:
 */
public class EfficientAlgorithmForRaisingN {
    double getPower(float x, int n) {
        double ret = 1;
        long N = n;
        if (N == 0) return ret;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        while (N != 0) {
            // 如果次数为奇数，多乘一次x
            if (N % 2 == 1) {
                ret = ret * x;
            }
            // 次数减半，x平方
            N = N / 2;
            x = x * x;
        }
        return ret;
    }

    public static void main(String[] args) {
        EfficientAlgorithmForRaisingN ea = new EfficientAlgorithmForRaisingN();
        System.out.println(ea.getPower(2, -2));
    }
}
