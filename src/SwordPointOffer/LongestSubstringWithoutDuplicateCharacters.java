package SwordPointOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Wenhang Chen
 * @Description:请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 * @Date: Created in 9:46 4/13/2020
 * @Modified by:
 */
public class LongestSubstringWithoutDuplicateCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max_len = 0;
        int len = 0;
        int start = 0;
        int end = 0;
        // 双指针
        while (end < s.length()) {
            char c = s.charAt(end);
            while (set.contains(c) && start < end) {
                set.remove(s.charAt(start));
                start++;
                len--;
            }
            set.add(c);
            end++;
            len++;
            max_len = Math.max(len, max_len);
        }
        return max_len;
    }
}























