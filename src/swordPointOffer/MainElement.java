package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * @Date: Created in 9:22 5/18/2020
 * @Modified by:
 */
public class MainElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1)
            return -1;
        int cnt = 0;
        int num = nums[0];
        for (int n : nums) {
            if (n == num) {
                cnt++;
            } else {
                if (cnt > 0) {
                    cnt--;
                } else {
                    num = n;
                    cnt = 1;
                }
            }
        }
        if (cnt > 0) {
            return num;
        } else {
            System.out.println(cnt);
            return -1;
        }
    }

}





















