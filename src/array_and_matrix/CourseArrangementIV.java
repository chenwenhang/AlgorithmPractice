package array_and_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:你总共需要上 n 门课，课程编号依次为 0 到 n-1 。
 * <p>
 * 有的课会有直接的先修课程，比如如果想上课程 0 ，你必须先上课程 1 ，那么会以 [1,0] 数对的形式给出先修课程数对。
 * <p>
 * 给你课程总数 n 和一个直接先修课程数对列表 prerequisite 和一个查询对列表 queries 。
 * <p>
 * 对于每个查询对 queries[i] ，请判断 queries[i][0] 是否是 queries[i][1] 的先修课程。
 * <p>
 * 请返回一个布尔值列表，列表中每个元素依次分别对应 queries 每个查询对的判断结果。
 * <p>
 * 注意：如果课程 a 是课程 b 的先修课程且课程 b 是课程 c 的先修课程，那么课程 a 也是课程 c 的先修课程。
 * <p>
 * 输入：n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 * 输出：[false,true]
 * 解释：课程 0 不是课程 1 的先修课程，但课程 1 是课程 0 的先修课程。
 * <p>
 * 输入：n = 2, prerequisites = [], queries = [[1,0],[0,1]]
 * 输出：[false,false]
 * 解释：没有先修课程对，所以每门课程之间是独立的。
 * @Date: Created in 8:59 7/7/2020
 * @Modified by:
 */
public class CourseArrangementIV {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] arr = new boolean[n][n];
        // 没想到吧，还能这么写！
        for (int[] p : prerequisites) {
            int l = p[0], r = p[1];
            arr[l][r] = true; //l->r
            for (int i = 0; i < n; i++) {
                if (arr[i][l]) { //i->l 那么 i->l->r 即i->1
                    arr[i][r] = true;
                }
            }
            for (int j = 0; j < n; j++) {
                if (arr[r][j]) { //r->j 那么 l->r->j 即l->j
                    arr[l][j] = true;
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            res.add(arr[queries[i][0]][queries[i][1]]);
        }
        return res;
    }

}
