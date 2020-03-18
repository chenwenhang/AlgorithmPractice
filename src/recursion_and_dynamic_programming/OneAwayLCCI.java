package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * @Date: Created in 9:06 3/18/2020
 * @Modified by:
 */
public class OneAwayLCCI {
    public boolean oneEditAway(String first, String second) {
        if (first == null && second == null) return true;
        if (first == null || second == null) return false;
        if (first.equals(second)) return true;
        int cnt = 0;
        int m = first.length();
        int n = second.length();
        if (m == n) {
            for (int i = 0; i < m; i++) {
                if (first.charAt(i) != second.charAt(i)) cnt++;
            }
        } else if (m - n == 1) {
            int i = 0;
            int j = 0;
            while (i < m && j < n) {
                if (first.charAt(i) == second.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                    cnt++;
                }
            }
        } else if (n - m == 1) {
            int i = 0;
            int j = 0;
            while (i < m && j < n) {
                if (first.charAt(i) == second.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                    cnt++;
                }
            }
        } else {
            return false;
        }
        return cnt <= 1;
    }
}



























