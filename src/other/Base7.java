package other;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个整数，将其转化为7进制，并以字符串形式输出。 示例 1:
 * <p>
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * @Date: Created in 10:13 3/1/2020
 * @Modified by:
 */
public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean flag = false;
        StringBuilder s = new StringBuilder();
        if (num < 0) {
            flag = true;
            num = -num;
        }
        while (num > 0) {
            s.insert(0, num % 7);
            num /= 7;
        }
        if (flag) s.insert(0, '-');
        return s.toString();
    }
}






















