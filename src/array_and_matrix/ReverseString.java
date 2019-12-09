package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * @Date: Created in 10:50 12/9/2019
 * @Modified by:
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) return;
        int len = s.length;
        char tmp;
        for (int i = 0; i < len / 2; i++) {
            tmp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = tmp;
        }
    }
}
