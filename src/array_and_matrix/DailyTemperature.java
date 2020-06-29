package array_and_matrix;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Wenhang Chen
 * @Description:请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * @Date: Created in 10:01 6/29/2020
 * @Modified by:
 */
public class DailyTemperature {
    // 单调栈
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    // 暴力优化
//    public int[] dailyTemperatures(int[] T) {
//        if (T == null || T.length < 1) return null;
//        int[] num = new int[T.length];
//        num[T.length - 1] = 0;
//        int max_num = T[T.length - 1];
//        int max_pos = T.length - 1;
//        for (int i = T.length - 2; i >= 0; i--) {
//            if (max_num <= T[i]) {
//                num[i] = 0;
//                max_num = T[i];
//                max_pos = i;
//            } else {
//                for (int j = i + 1; j <= max_pos; j++) {
//                    if (T[j] > T[i]) {
//                        num[i] = j - i;
//                        break;
//                    }
//                }
//            }
//        }
//        return num;
//    }
}















