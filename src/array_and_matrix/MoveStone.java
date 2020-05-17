package array_and_matrix;

import java.util.Arrays;

/**
 * @Author: Wenhang Chen
 * @Description:三枚石子放置在数轴上，位置分别为 a，b，c。
 * <p>
 * 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 * <p>
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * <p>
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 2, c = 5
 * 输出：[1, 2]
 * 解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 3, c = 2
 * 输出：[0, 0]
 * 解释：我们无法进行任何移动。
 * @Date: Created in 21:13 5/17/2020
 * @Modified by:
 */
public class MoveStone {
//    首先排序，排序并不会改变结果，但是我们写起来更方便一点，然后重新赋值abc
//    a最小,c最大，因为只能拿两边的石头往中间放，所以最大情况就是一步一步挪，那么就是c-a-2
//    最小情况多重情况讨论即可
//    三个紧贴着 c-a=2 返回0
//    其中有两个紧贴着 返回1
//    其中有两个中间空了一格 返回 1
//    最小移动次数最大是2 就是两边分别往中间放
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        int min = 0;
        if (c - a == 2) min = 0;
        else if (b - a == 1 || c - b == 1) min = 1;
        else if (b - a == 2 || c - b == 2) min = 1;
        else min = 2;
        return new int[]{min, c - a - 2};
    }


}
