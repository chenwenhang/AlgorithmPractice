package divide_and_conquer;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @Date: Created in 15:57 11/14/2019
 * @Modified by:
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len;

        while (left < right) {
            int mid = (right + left) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
