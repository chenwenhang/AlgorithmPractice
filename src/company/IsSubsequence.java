package company;

/**
 * @Author: Wenhang Chen
 * @Description:给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * @Date: Created in 9:03 2/23/2020
 * @Modified by:
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int pos = 0;
        while (i < s.length()) {
            if (pos >= t.length()) return false;
            int j = pos;
            for (; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    pos = j + 1;
                    break;
                }
            }
            if (j == t.length()) {
                return false;
            }
        }
        return true;
    }
}



















