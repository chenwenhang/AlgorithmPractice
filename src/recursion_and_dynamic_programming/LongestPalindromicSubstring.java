package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个字符串s，找到s中最长的回文子串。你可以假设s的最大长度为1000。
 * @Date: Created in 10:46 11/15/2019
 * @Modified by:
 */
public class LongestPalindromicSubstring {
    /*
    * dp[i][i]=true; // 单个字符是回文串
    * dp[i][i+1]=true if s[i]=s[i+1]; // 连续两个相同字符是回文串
    * dp[i][j]=true if s[i]==s[j] && dp[i + 1][j - 1]; // 状态转移方程
    */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        // 记录开始和结束位置
        int start = 0, end = 0;
        // dp数组
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化，dp[i][i]表示单个字符为true，同时如果相邻两个字符相同，则dp[i][i+1]=true
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }
        // l表示检索的子串长度，从长度为3开始检索字符串
        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i + l - 1 < s.length(); i++) {
                int j = l + i - 1;//终止字符位置
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
