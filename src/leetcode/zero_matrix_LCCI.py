from typing import List


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        rows = set()
        cols = set()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    rows.add(i)
                    cols.add(j)
        for i in rows:
            for j in range(len(matrix[0])):
                matrix[i][j] = 0
        for j in cols:
            for i in range(len(matrix)):
                matrix[i][j] = 0
        print(matrix)


sol = Solution()
sol.setZeroes([
    [1, 1, 1],
    [1, 0, 1],
    [1, 1, 1]
])
