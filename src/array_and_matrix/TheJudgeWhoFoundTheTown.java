package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * <p>
 * 如果小镇的法官真的存在，那么：
 * <p>
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 * <p>
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 2, trust = [[1,2]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：N = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * 示例 4：
 * <p>
 * 输入：N = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出：3
 * @Date: Created in 19:33 5/20/2020
 * @Modified by:
 */
public class TheJudgeWhoFoundTheTown {
    public int findJudge(int N, int[][] trust) {
        int[] cnt = new int[N + 1];//统计出入度
        for (int[] index : trust) {
            cnt[index[0]]--;//出度--
            cnt[index[1]]++;//入度++
        }
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == N - 1) return i;
        }
        return -1;
    }
}























