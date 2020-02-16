package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * @Date: Created in 9:49 2/16/2020
 * @Modified by:
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        for (int left = 0; left <= length_ - possibleDups; left++) {

            if (arr[left] == 0) {
                if (left == length_ - possibleDups) {
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        int last = length_ - possibleDups;

        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}





















