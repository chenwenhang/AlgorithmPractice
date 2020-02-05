package company;

import java.util.Arrays;

/**
 * @Author: Wenhang Chen
 * @Description:老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * @Date: Created in 11:24 2/5/2020
 * @Modified by:
 */
public class Candy {
//    // 暴力法
//    public int candy(int[] ratings) {
//        if (ratings == null || ratings.length < 1) return 0;
//        int[] candies = new int[ratings.length];
//        Arrays.fill(candies, 1);
//        boolean flag = true;
//        int sum = 0;
//        // 一直循环到糖果分配不再变化
//        while (flag) {
//            flag = false;
//            for (int i = 0; i < ratings.length; i++) {
//                // 如果当前评分比后一个大而糖果比后一个少，则更新糖果
//                if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
//                    candies[i] = candies[i + 1] + 1;
//                    flag = true;
//                }
//                // 如果当前评分比前一个大而糖果比前一个少，则更新糖果
//                if (i != 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
//                    candies[i] = candies[i - 1] + 1;
//                    flag = true;
//                }
//            }
//        }
//        for (int candy : candies) sum += candy;
//        return sum;
//    }

//    // 用两个数组
//    public int candy(int[] ratings) {
//        if (ratings == null || ratings.length < 1) return 0;
//        int[] left2right = new int[ratings.length];
//        int[] right2left = new int[ratings.length];
//        Arrays.fill(left2right, 1);
//        Arrays.fill(right2left, 1);
//        int sum = 0;
//        for (int i = 1; i < ratings.length; i++) {
//            if (ratings[i] > ratings[i - 1]) {
//                left2right[i] = left2right[i - 1] + 1;
//            }
//        }
//        for (int i = ratings.length - 2; i >= 0; i--) {
//            if (ratings[i] > ratings[i + 1]) {
//                right2left[i] = right2left[i + 1] + 1;
//            }
//        }
//        for (int i = 0; i < ratings.length; i++)
//            sum += Math.max(left2right[i], right2left[i]);
//        return sum;
//    }

    // 用一个数组
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length < 1) return 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // 由于最后循环中会漏掉最后一个元素，所以这里初始化sum为最后一个元素
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // 此时candies已经从左到右更新一遍了，此时只需要与自身比较即可
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
            sum += candies[i];
        }
        return sum;
    }
}










