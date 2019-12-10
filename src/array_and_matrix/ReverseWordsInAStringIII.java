package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * @Date: Created in 8:59 12/10/2019
 * @Modified by:
 */
public class ReverseWordsInAStringIII {
    // 反转函数
    private void reverse(char[] cm, int start, int end) {
        for (int i = start; i <= end + start >> 1; i++) {
            char tmp = cm[i];
            cm[i] = cm[end + start - i];
            cm[end + start - i] = tmp;
        }
    }

    public String reverseWords(String s) {
        if (s == null || s.length() < 1) return s;
        int len = s.length();
        int start = 0;
        char[] cm = s.toCharArray();
        for (int i = 0; i < len; i++) {
            // 中途遇空格反转
            if (cm[i] == ' ') {
                reverse(cm, start, i - 1);
                start = i + 1;
            }
        }
        // 最后一个单词反转
        reverse(cm, start, len - 1);
        return String.valueOf(cm);
    }
}
