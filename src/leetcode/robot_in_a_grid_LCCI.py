from collections import deque
from typing import List


class Solution:
    def __init__(self):
        self.path = deque()
        self.final_path = []
        self.visited = []
        self.MAX_Y = 0
        self.MAX_X = 0
        self.isOk = False

    def pathWithObstacles(self, obstacleGrid: List[List[int]]) -> List[List[int]]:
        self.MAX_Y = len(obstacleGrid[0])
        self.MAX_X = len(obstacleGrid)
        self.visited = [[False] * len(obstacleGrid[0]) for _ in range(len(obstacleGrid))]
        self.recursive(obstacleGrid, 0, 0)
        print(self.final_path)
        return self.final_path

    def recursive(self, obstacleGrid: List[List[int]], x: int, y: int):
        if self.isOk or x >= self.MAX_X or y >= self.MAX_Y or self.visited[x][y]:
            return
        self.visited[x][y] = True
        if obstacleGrid[x][y] == 0:
            self.path.append([x, y])
            if x == self.MAX_X - 1 and y == self.MAX_Y - 1:
                self.final_path = list(self.path)
                self.isOk = True
            self.recursive(obstacleGrid, x + 1, y)
            self.recursive(obstacleGrid, x, y + 1)
            self.path.pop()
        else:
            return


sol = Solution()
sol.pathWithObstacles([
    [0, 0, 0],
    [0, 1, 0],
    [0, 0, 0]
])
