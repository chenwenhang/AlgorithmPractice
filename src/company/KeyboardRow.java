package company;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 示例：
 * <p>
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * @Date: Created in 11:05 2/25/2020
 * @Modified by:
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String[] rec = new String[3];
        rec[0] = "qwertyuiop";
        rec[1] = "asdfghjkl";
        rec[2] = "zxcvbnm";
        int len = words.length;
        List<String> list = new ArrayList<>();
        for (String str : words) {
            for (int j = 0; j < 3; j++) {
                boolean flag = true;
                for (int k = 0; k < str.length(); k++) {
                    char ch = str.charAt(k);
                    if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);
                    if (rec[j].indexOf(ch) == -1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list.add(str);
                    break;
                }
            }
        }
        return list.toArray(new String[]{});
    }
}
