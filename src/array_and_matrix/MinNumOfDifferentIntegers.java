package array_and_matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Wenhang Chen
 * @Description:给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 * 示例 2：
 * <p>
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 * @Date: Created in 20:38 6/28/2020
 * @Modified by:
 */
public class MinNumOfDifferentIntegers {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();//map来存储每个数字的次数
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int size = map.size();
        int[] cnt = new int[size];
        int m = 0;
        // 用keySet把每一个key取出来，然后用map.get(key)来取值
        // 之前用Map.Entry方法，感觉更繁琐
        for (int key : map.keySet()) {
            cnt[m++] = map.get(key);
        }
        Arrays.sort(cnt);
        // 排序之后，从小到大，如果k大于这个数字次数，那么这个数字就可以移除
        // 否则就break
        for (int c : cnt) {
            if (k >= c) {
                k -= c;
                size--;
            } else {
                break;
            }
        }
        return size;
    }
}






















