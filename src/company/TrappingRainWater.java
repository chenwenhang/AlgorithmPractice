package company;

/**
 * @Author: Wenhang Chen
 * @Description:给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * @Date: Created in 13:01 2/5/2020
 * @Modified by:
 */
public class TrappingRainWater {
//    // 暴力法
//    public int trap(int[] height) {
//        if (height == null || height.length < 1) return 0;
//        int sum = 0;
//        for (int i = 0; i < height.length; i++) {
//            int max_left = 0;
//            int max_right = 0;
//            for (int j = i; j >= 0; j--) {
//                max_left = Math.max(max_left, height[j]);
//            }
//            for (int j = i; j < height.length; j++) {
//                max_right = Math.max(max_right, height[j]);
//            }
//            sum += Math.min(max_left, max_right) - height[i];
//        }
//        return sum;
//    }

//    // 用数组存储最大值
//    public int trap(int[] height) {
//        if (height == null || height.length < 1) return 0;
//        int sum = 0;
//        int[] left = new int[height.length];
//        int[] right = new int[height.length];
//        int max_left = 0;
//        int max_right = 0;
//        for (int i = 0; i < height.length; i++) {
//            max_left = Math.max(max_left, height[i]);
//            left[i] = max_left;
//        }
//        for (int i = height.length - 1; i >= 0; i--) {
//            max_right = Math.max(max_right, height[i]);
//            right[i] = max_right;
//        }
//        for (int i = 0; i < height.length; i++) {
//            sum += Math.min(left[i], right[i]) - height[i];
//        }
//        return sum;
//    }

    // 双指针
    public int trap(int[] height) {
        if (height == null || height.length < 1) return 0;
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int max_left = 0;
        int max_right = 0;
        while (left < right) {
            // 使用当前位置的值作比较是因为，
            // 存在当前位置的值大于记录的最大值的情况
            // 如果直接比较max_left和max_right，就可能
            // 产生少加值的情况，因为那时候的max还没有更新
            // 采用当前值可以保证max始终是最大的
            if (height[left] < height[right]) {
                if (height[left] < max_left) {
                    sum += max_left - height[left];
                } else {
                    max_left = height[left];
                }
                left++;
            } else {
                if (height[right] < max_right) {
                    sum += max_right - height[right];
                } else {
                    max_right = height[right];
                }
                right--;
            }
        }
        return sum;
    }

}















