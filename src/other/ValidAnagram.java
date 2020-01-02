package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Wenhang Chen
 * @Description:给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * @Date: Created in 9:47 1/2/2020
 * @Modified by:
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null || s.length() != t.length())
            return false;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); ) {
            int key = s.codePointAt(i);
            if (!hm.containsKey(key)) {
                hm.put(key, 1);
            } else {
                hm.put(key, hm.get(key) + 1);
            }
            // 判断Unicode 代码点是否在附加级别字符范围内
            if (Character.isSupplementaryCodePoint(key))
                i += 2;
            else
                i++;
        }
        System.out.println(hm.toString());
        for (int i = 0; i < t.length(); ) {
            int key = t.codePointAt(i);
            if (!hm.containsKey(key)) {
                return false;
            } else {
                hm.put(key, hm.get(key) - 1);
            }
            // 判断Unicode 代码点是否在附加级别字符范围内
            if (Character.isSupplementaryCodePoint(key))
                i += 2;
            else
                i++;
        }
        for (Map.Entry entry : hm.entrySet()) {
            //System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            if ((int) entry.getValue() != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        va.isAnagram("rat", "car");
    }
}















