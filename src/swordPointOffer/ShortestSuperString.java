package swordPointOffer;

import java.util.*;

/**
 * @Author: Wenhang Chen
 * @Description:假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * 示例 2:
 * <p>
 * 输入:
 * big = [1,2,3]
 * small = [4]
 * 输出: []
 * 提示：
 * <p>
 * big.length <= 100000
 * 1 <= small.length <= 100000
 * @Date: Created in 10:15 4/27/2020
 * @Modified by:
 */
public class ShortestSuperString {
    public int[] shortestSeq(int[] big, int[] small) {
        if (small.length > big.length)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        int count = small.length;
        int[] ans = {0, big.length};

        for (int i : small)
            map.put(i, -1);

        for (int i = 0; i < big.length; i++) {
            if (map.containsKey(big[i])) {
                if (map.get(big[i]) == -1)
                    count--;
                map.put(big[i], i);
            }
            if (count <= 0) {
                Collection<Integer> c = map.values();
                Object[] obj = c.toArray();
                int minNum = getMin(obj);
                if (i - minNum + 1 < ans[1] - ans[0] + 1) {
                    ans[0] = minNum;
                    ans[1] = i;
                }
            }
        }
        if (count > 0)
            return new int[0];
        return ans;
    }

    int getMin(Object[] obj) {
        int minNum = Integer.MAX_VALUE;
        for (Object i : obj) {
            minNum = Math.min((int) i, minNum);
        }
        return minNum;
    }
}


















