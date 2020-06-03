package array_and_matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 8:58 6/3/2020
 * @Modified by:
 */
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new LinkedList<>();
        int min = 99999999;
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i] - arr[i - 1];
            // 找到新的最小差，清空原有结果
            if (tmp < min) {
                min = tmp;
                res.clear();
            }
            // 如果是最小差，记录
            if (tmp == min) {
                List<Integer> item = new ArrayList<>(2);
                item.add(arr[i - 1]);
                item.add(arr[i]);
                res.add(item);
            }
        }
        return res;
    }
}
