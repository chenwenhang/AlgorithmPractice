# 题目描述
# 某某公司开发了一款生存类游戏，游戏地图大小用m * n 的网格 grid 进行了标注。每一个地图单元格都有生存所需的资源；如果该单元格没有生存资源，那么就是 0，玩家每到地图一个单元可以获取对应位置的资源，用以生存储备。
#
# 为了使生存储备最大化，玩家需要按以下规则来收集资源：
# 1，每当玩家进入一个地图单元，就会收集该单元格中的所有资源。
# 2，玩家每次可以从当前位置向上下左右四个方向走。
# 3，每个单元格只能被收集（进入）一次。
# 4，不得收集（进入）资源数目为 0 的单元格。（没有收获还耗费体力）
# 5，玩家可以从地图中 任意一个 有资源的单元格出发或者是停止。
#
# 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
#
# 输入
# [[0,6,0],[5,8,7],[0,9,0]]
#
# 输出
# 24
#
# 说明
# 收集路线为 7->8->9
#
# 示例2输入输出示例仅供调试，后台判题数据一般不包含示例
#
# 输入
# [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
#
# 输出
# 28
#
# 说明
# 收集路线为1->2->3->4->5->6->7
# 备注:
# 0<=n<=10000
# 0<=m<=10000

from typing import List


class Solution:
    def __init__(self):
        self.max_value = 0
        self.MAX_X = 0
        self.MAX_Y = 0
        self.grid = []
        self.visited = []
        self.dir_list = ["W", "A", "S", "D"]

    def direction(self, dir: str, pos: List[int]):
        x, y = pos
        if dir == "W":
            if x - 1 >= 0:
                return [x - 1, y]
        elif dir == "A":
            if y - 1 >= 0:
                return [x, y - 1]
        elif dir == "S":
            if x + 1 < self.MAX_X:
                return [x + 1, y]
        elif dir == "D":
            if y + 1 < self.MAX_Y:
                return [x, y + 1]
        else:
            return None

    def getMaximumResource(self, grid: List[List[int]]) -> int:
        self.grid = grid
        self.MAX_X = len(grid)
        self.MAX_Y = len(grid[0])
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                self.visited = [[False for _ in range(len(grid[0]))] for t in range(len(grid))]
                self.dfs([i, j], 0)
                # print()
        # print(self.max_value)
        return self.max_value

    def dfs(self, pos: List[int], cur_value: int) -> None:
        x, y = pos
        if self.grid[x][y] == 0:
            return
        self.visited[x][y] = True
        cur_value += self.grid[x][y]
        # print("pos: {}, val: {}".format(pos, cur_value))
        for dir in self.dir_list:
            new_pos = self.direction(dir, pos)
            if new_pos:
                new_x, new_y = new_pos
                if not self.visited[new_x][new_y]:
                    self.dfs(new_pos, cur_value)
        self.max_value = cur_value if cur_value > self.max_value else self.max_value


sol = Solution()
sol.getMaximumResource([[0, 6, 0], [5, 8, 7], [0, 9, 0]])
sol = Solution()
sol.getMaximumResource([[1, 0, 7], [2, 0, 6], [3, 4, 5], [0, 3, 0], [9, 0, 20]])
