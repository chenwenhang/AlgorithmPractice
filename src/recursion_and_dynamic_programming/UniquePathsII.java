package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 * @Date: Created in 19:30 12/29/2019
 * @Modified by:
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 行列
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // 起点有障碍物，无路径
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // 初始化起点
        obstacleGrid[0][0] = 1;
        // 若该列没有障碍物，则能通行，否则后面都不可通行，因为只能向下或向右
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // 对于第一行同理
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // 开始dp
        // 若当前点无障碍物，则等于obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // 返回终点处的值
        return obstacleGrid[R - 1][C - 1];
    }
}



















