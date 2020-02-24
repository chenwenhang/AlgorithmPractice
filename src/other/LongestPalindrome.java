package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * @Date: Created in 11:18 2/24/2020
 * @Modified by:
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int num = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
//            当Map集合中有这个key时，就使用这个key值
//            如果没有就使用默认值defaultValue
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int value : map.values()) {
            num += value / 2 * 2;
            if (num % 2 == 0 && value % 2 == 1) {
                num += 1;
            }
        }
        return num;
    }
}

















