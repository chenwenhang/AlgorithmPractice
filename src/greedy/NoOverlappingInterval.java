package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * <p>
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * @Date: Created in 19:02 6/13/2020
 * @Modified by:
 */
public class NoOverlappingInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return 0;

        Arrays.sort(intervals, (x, y) -> x[1] - y[1]);

        int bound = intervals[0][1], res = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < bound) res++;
            else bound = intervals[i][1];
        }

        return res;
    }

}























