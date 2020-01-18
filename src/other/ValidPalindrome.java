package other;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * @Date: Created in 21:39 1/18/2020
 * @Modified by:
 */
public class ValidPalindrome {
    public boolean isValidCharacter(char c) {
        return c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 1) return true;
        s = s.toUpperCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (isValidCharacter(startChar) && isValidCharacter(endChar)) {
                if (startChar == endChar) {
                    start++;
                    end--;
                } else {
                    break;
                }
            }
            if (!isValidCharacter(startChar)) {
                start++;
            }
            if (!isValidCharacter(endChar)) {
                end--;
            }

        }
        return start >= end;
    }
}
