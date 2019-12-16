package array_and_matrix;

import java.util.Random;

/**
 * @Author: Wenhang Chen
 * @Description:在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * @Date: Created in 9:47 12/16/2019
 * @Modified by:
 */
public class KthLargestElementInAnArray {
    // 算法平均时间复杂度为O(N)
    // 采用快速排序的思想，只需要选到
    // partition 操作的时间复杂度逐次为 O(N + N/2 + N/4....+1) = O(2N-1) = O(N)
    // 与快速排序不同的是，快排需要对两个划分的子部分都要进行递归，而该算法只需要对
    // 其中的一边进行递归划分即可
    int[] nums;

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot = nums[pivot_index];

        // 先把轴元素移到末端，方便后续移动元素的操作，
        // 不用再考虑如果移动过程中恰好有轴元素怎么办
        // 如果置之不理，轴元素最终位置很可能不正确
        swap(pivot_index, right);

        // 元素存放位置
        int store_index = left;

        // 开始比较
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 移回来
        swap(store_index, right);

        return store_index;
    }

    public int quickselect(int left, int right, int k_smallest) {
        // 若仅剩下一个元素，则该元素即为第size-k小元素
        if (left == right) return nums[left];

        // 先随机选择轴元素位置
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        // 获取划分数组后轴元素的真实位置
        pivot_index = partition(left, right, pivot_index);

        // 如果轴元素位置即为k_smallest，则返回，否则递归继续求解
        if (k_smallest == pivot_index) {
            return nums[k_smallest];
        } else if (k_smallest < pivot_index) {
            return quickselect(left, pivot_index - 1, k_smallest);
        } else {
            return quickselect(pivot_index + 1, right, k_smallest);
        }

    }

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;

        // 第k大元素，即第size-k小元素
        return quickselect(0, size - 1, size - k);
    }
}


















