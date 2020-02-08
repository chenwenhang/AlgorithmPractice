package company;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * @Date: Created in 12:55 2/8/2020
 * @Modified by:
 */
public class NumberOfIslands {
    char[][] grid;
    char sign = '2';

    public boolean isLegal(int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    public void dfs(int x, int y, boolean flag) {
        grid[x][y] = sign;
        if (isLegal(x - 1, y) && grid[x - 1][y] == '1') {
            dfs(x - 1, y, false);
        }
        if (isLegal(x + 1, y) && grid[x + 1][y] == '1') {
            dfs(x + 1, y, false);
        }
        if (isLegal(x, y - 1) && grid[x][y - 1] == '1') {
            dfs(x, y - 1, false);
        }
        if (isLegal(x, y + 1) && grid[x][y + 1] == '1') {
            dfs(x, y + 1, false);
        }
        // 只有在第一次进入新的岛屿时，菜更新sign
        if (flag) {
            sign++;
        }
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, true);
                }
            }
        }
        return sign - '2';
    }
}






















