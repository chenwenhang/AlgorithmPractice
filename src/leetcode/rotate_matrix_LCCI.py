from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # 先按主对角线翻转，再按列逆序
        for i in range(len(matrix)):
            for j in range(i + 1, len(matrix[0])):
                t = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = t
        # print(matrix)
        for i in range(len(matrix)):
            for j in range(len(matrix[0]) // 2):
                t = matrix[i][j]
                matrix[i][j] = matrix[i][len(matrix[0]) - j - 1]
                matrix[i][len(matrix[0]) - j - 1] = t
        # print(matrix)


sol = Solution()
sol.rotate([
    [5, 1, 9, 11],
    [2, 4, 8, 10],
    [13, 3, 6, 7],
    [15, 14, 12, 16]
])
