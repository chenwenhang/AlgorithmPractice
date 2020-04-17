package swordPointOffer;

import java.util.LinkedList;

/**
 * @Author: Wenhang Chen
 * @Description:输入一个字符串，打印出该字符串中字符的所有排列。  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * @Date: Created in 9:22 3/26/2020
 * @Modified by:
 */
public class ArrangementOfStrings {
    char[] chars;
    LinkedList<String> res;

    public String[] permutation(String s) {
        //回溯
        this.chars = s.toCharArray();
        this.res = new LinkedList<>();
        traceBack(0, s.length());
        return res.toArray(new String[0]);
    }

    void traceBack(int start, int end) {
        if (start == end) {
            res.add(new String(chars));
            return;
        }
        boolean[] used = new boolean[128];//这里用的是字符的ascii码值 0-127
        for (int i = start; i < end; i++) {
            if (used[chars[i]]) continue;//重复的就不在交换了
            used[chars[i]] = true;
            swap(start, i);
            traceBack(start + 1, end);
            swap(start, i);
        }
    }

    void swap(int start, int i) {
        char temp = chars[start];
        chars[start] = chars[i];
        chars[i] = temp;
    }

}















