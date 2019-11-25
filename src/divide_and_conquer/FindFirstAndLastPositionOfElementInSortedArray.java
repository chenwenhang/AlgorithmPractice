package divide_and_conquer;

import java.util.Arrays;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * @Date: Created in 19:45 11/21/2019
 * @Modified by:
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    // 两次二分查找
    // 第一次从查找的时候对左边采用排除法，那么最终夹逼出来的第一个数就是第一次出现的位置
    // 第二次查找的时候对右边采用排除法，同理
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length < 1) return res;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + right >>> 1;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        // 保证不越界，并且要再做一次检查
        res[0] = (left < nums.length && nums[left] == target) ? left : -1;

        left = 0;
        right = nums.length - 1;
        while (left < right) {
            // 当分支不能排除左边界时，需要选择右中位数，选择左中位数会出现死循环
            int mid = left + right + 1 >>> 1;// 排除右边使用右中位数
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid;
        }
        res[1] = nums[left] == target ? left : -1;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }
}
