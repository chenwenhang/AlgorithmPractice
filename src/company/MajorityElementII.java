package company;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 * <p>
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 * @Date: Created in 10:03 2/12/2020
 * @Modified by:
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        // 超过n/3的数最多只能有两个
        int A = nums[0];
        int B = nums[0];
        int countA = 0;
        int countB = 0;
        for (int num : nums) {
            // 如果num等于候选数，count++
            if (num == A) {
                countA++;
                continue;
            }
            if (num == B) {
                countB++;
                continue;
            }
            // 如果候选数计数变为0，更新候选数为当前数，count++
            if (countA == 0) {
                A = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                B = num;
                countB++;
                continue;
            }
            // 如果当前数不为候选数，count--
            countA--;
            countB--;
        }
        countA = 0;
        countB = 0;
        // 再来一次，确认count是否大于k/3
        for (int num : nums) {
            if (num == A) {
                countA++;
            } else if (num == B) {
                countB++;
            }
        }
        if (countA > nums.length / 3) {
            res.add(A);
        }
        if (countB > nums.length / 3) {
            res.add(B);
        }
        return res;
    }
}















