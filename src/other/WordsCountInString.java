package other;

/**
 * @Author: Wenhang Chen
 * @Description:统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * @Date: Created in 10:58 6/10/2020
 * @Modified by:
 */
public class WordsCountInString {
    public int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}
















