package array_and_matrix;

import java.util.Arrays;

/**
 * @Author: Wenhang Chen
 * @Description:给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * @Date: Created in 10:51 11/26/2019
 * @Modified by:
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n < 1) return;
        int[] tmp = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        for (; i < m && j < n; ) {
            if (nums1[i] <= nums2[j]) {
                tmp[k] = nums1[i];
                k++;
                i++;
            } else {
                tmp[k] = nums2[j];
                k++;
                j++;
            }
        }
        for (; i < m; ) {
            tmp[k] = nums1[i];
            i++;
            k++;
        }
        for (; j < n; ) {
            tmp[k] = nums2[j];
            j++;
            k++;
        }
        for (i = 0; i < k; i++) {
            nums1[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        MergeSortedArray ma = new MergeSortedArray();
        ma.merge(nums1, 3, nums2, 3);
    }
}













