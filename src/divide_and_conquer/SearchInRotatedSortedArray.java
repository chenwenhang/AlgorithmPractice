package divide_and_conquer;

/**
 * @Author: Wenhang Chen
 * @Description:假设按照升序排序的数组在预先未知的某个点上进行了旋转。 (例如 ， 数组   [0, 1, 2, 4, 5, 6, 7]   可能变为   [4, 5, 6, 7, 0, 1, 2]  )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * @Date: Created in 21:28 11/18/2019
 * @Modified by:
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        int left = 0, right = nums.length - 1;
        // 典型二分查找模版
        while (left < right) {
            int mid = (left + right) / 2;
            // 三项均为真或只有一项为真向后规约（即排除该情况）
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
    }
}
