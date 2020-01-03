package other;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * @Date: Created in 8:55 1/3/2020
 * @Modified by:
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) return -1;
        int[] count = new int[27];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}





















