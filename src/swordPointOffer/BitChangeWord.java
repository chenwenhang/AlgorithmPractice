package swordPointOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 9:16 4/26/2020
 * @Modified by:
 */
public class BitChangeWord {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int length = strs.length;
        if (length == 0)
            return res;
        Map<String, Integer> map = new HashMap<>();

        List<String> tempList;
        for (int i = 0; i < length; i++) {
            String temp = sort(strs[i]);
            if (map.get(temp) == null) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(temp, res.size());
                res.add(list);
            } else {
                int index = map.get(temp);
                tempList = res.get(index);
                tempList.add(strs[i]);
            }
        }

        return res;
    }

    // 桶排序
    public String sort(String s) {
        StringBuilder builder = new StringBuilder();
        int[] buckets = new int[26];
        int length = s.length();

        for (int i = 0; i < length; i++)
            buckets[s.charAt(i) - 'a']++;

        for (int i = 0; i < 26; i++) {
            while (buckets[i] > 0) {
                builder.append((char) (i + 'a'));
                buckets[i]--;
            }
        }

        return builder.toString();
    }
}













