package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。.
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @Date: Created in 21:18 11/25/2019
 * @Modified by:
 */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return null;
        int[][] matrix = new int[n][n];
        int flagNum = 0;
        int maxNum = n * n;
        int i = 0, j = 0;
        int r1 = 0, r2 = 0, r3 = 0, r4 = 0;
        while (flagNum < maxNum) {
            // 每次都要判断是否已遍历完
            for (; j < n - r1 && flagNum < maxNum; j++) {
                flagNum++;
                matrix[i][j] = flagNum;
            }
            // 注意要复位
            r4++;
            j--;
            i++;
            for (; i < n - r2 && flagNum < maxNum; i++) {
                flagNum++;
                matrix[i][j] = flagNum;
            }
            r1++;
            i--;
            j--;
            for (; j >= r3 && flagNum < maxNum; j--) {
                flagNum++;
                matrix[i][j] = flagNum;
            }
            r2++;
            j++;
            i--;
            for (; i >= r4 && flagNum < maxNum; i--) {
                flagNum++;
                matrix[i][j] = flagNum;
            }
            r3++;
            i++;
            j++;
        }
        return matrix;
    }
}