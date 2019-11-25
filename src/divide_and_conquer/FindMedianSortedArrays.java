package divide_and_conquer;

/**
 * @Author: Wenhang Chen
 * @Description:给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * @Date: Created in 10:58 11/18/2019
 * @Modified by:
 */
public class FindMedianSortedArrays {
    // 题解：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 采用求第k小数策略
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);
        int iMin = 0, iMax = m;
        // 这里是采用二分的思想找边界
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;// i 增大，j 自然减小，反之亦然
            int j = (m + n + 1) / 2 - i;
            // 其中一个数组的左半部分小了，另一个数组的左半部分就应该增大，同时保证不越界
            if (j != 0 && i != m && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                // 如果一个数组的左边已经没有数了，那么左边的最大值等于另一个数组的下标为j-1的数
                if (i == 0) maxLeft = nums2[j - 1];
                else if (j == 0) maxLeft = nums1[i - 1];
                // 否则，取左半部分最大的数
                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                // 如果是奇数个数，之间返回maxLeft
                if ((m + n) % 2 == 1) return maxLeft;

                int minRight = 0;
                // 如果一个数组的右边已经没有数了，那么右边的最小值等于另一个数组的下标为j的数
                if (i == m) minRight = nums2[j];
                else if (j == n) minRight = nums1[i];
                // 否则，取右半部分最小的数
                else minRight = Math.min(nums1[i], nums2[j]);

                // 如果是偶数个数，返回二者的平均值
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }
}
