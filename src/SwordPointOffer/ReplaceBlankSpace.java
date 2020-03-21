package SwordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 9:48 3/21/2020
 * @Modified by:
 */
public class ReplaceBlankSpace {
    public String replaceSpace(String s) {
        if (s == null || s.length() < 1) return s;
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(i, '%');
                sb.insert(i + 1, "20");
                i += 3;
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}

















