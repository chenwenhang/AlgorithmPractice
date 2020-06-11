package other;

/**
 * @Author: Wenhang Chen
 * @Description:给定两个表示复数的字符串。 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1+1i", "1+1i"
 * 输出: "0+2i"
 * 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2:
 * <p>
 * 输入: "1+-1i", "1+-1i"
 * 输出: "0+-2i"
 * 解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 * 注意:
 * <p>
 * 输入字符串不包含额外的空格。
 * 输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。
 * @Date: Created in 9:15 6/11/2020
 * @Modified by:
 */
public class ComplexMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] c1 = a.split("\\+");
        String[] c2 = b.split("\\+");

        // 实部系数
        int x1 = Integer.parseInt(c1[0]);
        int x2 = Integer.parseInt(c2[0]);

        // 虚部系数
        int y1 = 0;
        int y2 = 0;

        if (c1[1].charAt(0) == '-') {
            y1 = -Integer.parseInt(c1[1].substring(1, c1[1].length() - 1));
        } else {
            y1 = Integer.parseInt(c1[1].substring(1, c1[1].length() - 1));
        }

        if (c2[1].charAt(0) == '-') {
            y2 = -Integer.parseInt(c2[1].substring(1, c2[1].length() - 1));
        } else {
            y2 = Integer.parseInt(c2[1].substring(1, c2[1].length() - 1));
        }

        int x = x1 * x2 - y1 * y2;
        int y = x1 * y2 + x2 * y1;

        return x + "+" + y + "i";
    }
}






















