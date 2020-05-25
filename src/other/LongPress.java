package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 * <p>
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 *  
 * <p>
 * 提示：
 * <p>
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 * @Date: Created in 8:54 5/25/2020
 * @Modified by:
 */
public class LongPress {
    public boolean isLongPressedName(String name, String typed) {
        Group g1 = groupify(name);
        Group g2 = groupify(typed);
        if (!g1.key.equals(g2.key))
            return false;

        for (int i = 0; i < g1.count.size(); ++i)
            if (g1.count.get(i) > g2.count.get(i))
                return false;
        return true;
    }

    public Group groupify(String S) {
        StringBuilder key = new StringBuilder();
        List<Integer> count = new ArrayList();
        int anchor = 0;
        int N = S.length();
        for (int i = 0; i < N; ++i) {
            if (i == N - 1 || S.charAt(i) != S.charAt(i + 1)) { // end of group
                key.append(S.charAt(i));
                count.add(i - anchor + 1);
                anchor = i + 1;
            }
        }

        return new Group(key.toString(), count);
    }
}

class Group {
    String key;
    List<Integer> count;

    Group(String k, List<Integer> c) {
        key = k;
        count = c;
    }
}























