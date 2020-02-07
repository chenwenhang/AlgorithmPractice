package company;

import org.omg.CORBA.INTERNAL;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:给出一个区间的集合，请合并所有重叠的区间。 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @Date: Created in 14:04 2/7/2020
 * @Modified by:
 */
public class MergeIntervals {
    private static class Interval {
        int start;
        int end;

        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }

    // 比较器类
    private class IntervalComparator implements Comparator<Interval> {
        // 需要重写compare方法
        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> intervalsList = new LinkedList<>();
        for (int[] interval : intervals) {
            intervalsList.add(new Interval(interval));
        }
        // 先将列表按照开始区间排序
        intervalsList.sort(new IntervalComparator());
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervalsList) {
            // 如果merged为空，则添加
            // 如果merged中最后一个区间的结束小于当前区间的开始，直接添加
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                // 如果merged中最后一个区间的结束大于等于当前区间的开始，扩大最后一个区间的结束
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        int i = 0;
        int[][] result = new int[merged.size()][2];
        for (Interval mergedInterval : merged) {
            result[i] = mergedInterval.toArray();
            i++;
        }
        return result;
    }
}




















