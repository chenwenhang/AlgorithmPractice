package other;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个Excel表格中的列名称，返回其相应的列序号。 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * @Date: Created in 10:35 12/31/2019
 * @Modified by:
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() < 1) return 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            sum = sum * 26 + num;
        }
//        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
        escn.titleToNumber("C");
        escn.titleToNumber("AB");
        escn.titleToNumber("ZY");
        escn.titleToNumber("ABC");
    }
}



















