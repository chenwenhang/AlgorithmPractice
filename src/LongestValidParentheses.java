/**
 * @Author: Wenhang Chen
 * @Description:给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * @Date: Created in 10:19 11/20/2019
 * @Modified by:
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 1) return 0;
        //  dp 数组第 i 个元素表示以下标为 i 的字符结尾的最长有效子字符串的长度
        int[] dp = new int[s.length()];
        int maxNum = 0;
        for (int i = 1; i < s.length(); i++) {
            //有效的子字符串一定以 ) 结尾
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // str,(,)的情况，总长度为str长度加上2
                    // 需要保证i-2>=0，否则表示(,)在字符串开头，直接加2，str长度为0
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // str,(.sub,)的情况，总长度为 str+sub+2
                    // 需要保证sub前面不越界且为(
                    // 需要保证i - dp[i - 1]) >= 2，否则表示(.sub,)在字符串开头，str长度为0
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxNum = Math.max(maxNum, dp[i]);
            }
        }
        return maxNum;
    }
}
