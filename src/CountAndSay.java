/**
 * @Author: Wenhang Chen
 * @Description:报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 * @Date: Created in 11:31 11/22/2019
 * @Modified by:
 */
public class CountAndSay {
    // 涉及多次对String进行改变，例如本题在循环中对字符串进行拼接
    // 此时应当将String替换为StringBuilder操作
    // 经检验，本题将String改为StringBuilder后，效率大幅提升
    public static StringBuilder getString(int n, int k, StringBuilder s) {
        if (n == k) return s;
        StringBuilder str = new StringBuilder("");
        int count = 0;
        char num = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == num) {
                count++;
            }
            if (i + 1 >= s.length() || s.charAt(i + 1) != num) {
                // 这是最快的，直接采用StringBuilder
                str.append(count);
                str.append(num);
                // 下面这句效率会降低一些，因为中间涉及到了String的操作
                // str.append(Integer.toString(count) + num);
                count = 0;
                num = i + 1 < s.length() ? s.charAt(i + 1) : 0;
            }
        }
        return getString(n, k + 1, str);
    }

    public static String countAndSay(int n) {
        return getString(n, 1, new StringBuilder("1")).toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

}




















