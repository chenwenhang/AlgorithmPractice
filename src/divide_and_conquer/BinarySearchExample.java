package divide_and_conquer;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * @Date: Created in 16:06 11/14/2019
 * @Modified by:
 */
public class BinarySearchExample {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        if (left >= nums.length || nums[left] != target)
            return -1;

        return left;


    }
}
