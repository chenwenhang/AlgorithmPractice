package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 * <p>
 * 提示：
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * @Date: Created in 9:11 2/14/2020
 * @Modified by:
 */
public class RelativeSortArray {
    // 典型的空间换时间
    // python中in的操作也许可以用这种方式解决
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        // m[i]存储数字i出现的次数
        int[] m = new int[1001];

        // 存进m的过程本身就是使数字有序的过程
        for (int i = 0; i < arr1.length; i++) {
            m[arr1[i]]++;
        }

        int cnt = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (m[arr2[i]] > 0) {
                res[cnt++] = arr2[i];
                m[arr2[i]]--;
            }
        }

        // 最后把m中剩下的元素加进res
        for (int i = 0; i < 1001; i++) {
            while (m[i] > 0) {
                // 注意添加的是i
                res[cnt++] = i;
                m[i]--;
            }
        }

        return res;
    }
}




















