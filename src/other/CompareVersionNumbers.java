package other;

/**
 * @Author: Wenhang Chen
 * @Description:比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * <p>
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 * <p>
 *  . 字符不代表小数点，而是用于分隔数字序列。
 * <p>
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * <p>
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 * 示例 2:
 * <p>
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 * 示例 4：
 * <p>
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 * 示例 5：
 * <p>
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 * @Date: Created in 9:18 7/3/2020
 * @Modified by:
 */
public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int i = 0;
        while (i < s1.length && i < s2.length) {
            int t1 = Integer.parseInt(s1[i]);
            int t2 = Integer.parseInt(s2[i]);
            if (t1 > t2) {
                return 1;
            } else if (t1 < t2) {
                return -1;
            }
            i++;
        }
        while (i < s1.length) {
            int t1 = Integer.parseInt(s1[i]);
            if (t1 > 0) {
                return 1;
            }
            i++;
        }
        while (i < s2.length) {
            int t2 = Integer.parseInt(s2[i]);
            if (t2 > 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
    }
}





















