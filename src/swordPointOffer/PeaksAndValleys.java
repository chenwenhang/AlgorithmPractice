package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 6, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 *
 * 示例:
 *
 * 输入: [5, 3, 1, 2, 3]
 * 输出: [5, 1, 3, 2, 3]
 *
 * @Date: Created in 20:38 5/4/2020
 * @Modified by:
 */
public class PeaksAndValleys {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        for(int i = 1;i < n; i++){
            //如果是奇数，且小于前面的，或者如果是偶数，且大于前面的，那就要交换
            if(((i & 1) == 1 && nums[i] < nums[i-1])||((i &1) == 0 && nums[i] > nums[i-1])){
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }
    } 
}





















