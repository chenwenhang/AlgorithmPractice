package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
 * <p>
 * 请你统计并返回 grid 中 负数 的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 * <p>
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：grid = [[-1]]
 * 输出：1
 * @Date: Created in 19:55 5/14/2020
 * @Modified by:
 */
public class NegativeNumbersInOrderedMatrices {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int num = 0, right = n, left = 0;
        for (int i = 0; i < m; i++) {
            // right=left;有没有这句都行，因为上一次循环结束时这句必然成立。
            left = 0;
            while (left < right) {
                int middle = (left + right) / 2;
                if (grid[i][middle] >= 0) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            num += (n - left);
        }
        return num;

    }
}






















