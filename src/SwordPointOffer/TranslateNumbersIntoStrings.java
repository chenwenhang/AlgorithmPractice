package SwordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * @Date: Created in 10:27 4/14/2020
 * @Modified by:
 */
public class TranslateNumbersIntoStrings {

    // 动态规划的思路和 爬楼梯 是一样的
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int l = s.length();
        if (l == 1) return 1;
        int[] dp = new int[l + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < l; i++) {
            if (s.charAt(i - 1) != '0' && s.substring(i - 1, i + 1).compareTo("25") <= 0) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[l];
    }

}



















