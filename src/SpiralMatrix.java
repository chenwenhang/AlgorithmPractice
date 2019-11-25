import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * @Date: Created in 12:45 11/25/2019
 * @Modified by:
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spList = new ArrayList<>();
        if (matrix == null || matrix.length < 1) return spList;
        int row = matrix.length;
        int col = matrix[0].length;
        int flagNum = 0;
        int maxNum = row * col;
        int i = 0, j = 0;
        int r1 = 0, r2 = 0, r3 = 0, r4 = 0;
        while (flagNum < maxNum) {
            // 每次都要判断是否已遍历完
            for (; j < col - r1 && flagNum < maxNum; j++) {
                spList.add(matrix[i][j]);
                flagNum++;
            }
            // 注意要复位
            r4++;
            j--;
            i++;
            for (; i < row - r2 && flagNum < maxNum; i++) {
                spList.add(matrix[i][j]);
                flagNum++;
            }
            r1++;
            i--;
            j--;
            for (; j >= r3 && flagNum < maxNum; j--) {
                spList.add(matrix[i][j]);
                flagNum++;
            }
            r2++;
            j++;
            i--;
            for (; i >= r4 && flagNum < maxNum; i--) {
                spList.add(matrix[i][j]);
                flagNum++;
            }
            r3++;
            i++;
            j++;
        }
        return spList;
    }
}




















