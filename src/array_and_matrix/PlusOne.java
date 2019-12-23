package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * @Date: Created in 8:01 12/23/2019
 * @Modified by:
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int end = digits.length - 1;
        for (int i = end; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    int[] newDigits = new int[end + 2];
                    newDigits[0] = 1;
                    for (int j = 1; j < newDigits.length; j++) {
                        newDigits[j] = digits[j - 1];
                    }
                    return newDigits;
                }
            } else {
                digits[i] += 1;
                break;
            }
        }
        return digits;
    }

//    public int[] plusOne(int[] digits) {
////        作者：yhhzw
////        链接：https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
////        来源：力扣（LeetCode）
//        for (int i = digits.length - 1; i >= 0; i--) {
//            digits[i]++;
//            digits[i] = digits[i] % 10;
//            if (digits[i] != 0) return digits;
//        }
//    第一个数初始化为1，后面的不管，默认为0
//        digits = new int[digits.length + 1];
//        digits[0] = 1;
//        return digits;
//    }


}
