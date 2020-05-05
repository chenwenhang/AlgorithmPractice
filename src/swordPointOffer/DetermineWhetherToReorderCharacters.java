package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * @Date: Created in 21:05 5/5/2020
 * @Modified by:
 */
public class DetermineWhetherToReorderCharacters {
//    因为异或运算的特点是：相同的两个值的运算结果为0，并且满足交换律。
//    所以用异或计算两个字符串中所有字符。如果最终结果是0的话，
//    说明两个字符串中所有的字符都有对应出现。时间复杂度O(n),空间复杂度O(1)。

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int length = s1.length();
        if (length != s2.length()) {
            return false;
        }
        int result = 0;
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        int s1Sum = 0;
        int s2Sum = 0;
        for (int i = 0; i < s1Char.length; i++) {
            result = result ^ s1Char[i] ^ s2Char[i];
            s1Sum += s1Char[i];
            s2Sum += s2Char[i];
        }
        if (result == 0) {
            return s1Sum == s2Sum;
        }
        return false;
    }
}

















