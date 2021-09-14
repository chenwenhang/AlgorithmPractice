import sys


class Solution:
    def get_cost(self, h_m: dict, s: str, x: int, y: int, z: int) -> int:
        if s is None or s == "":
            return 0
        cost, i = 0, 0
        cur_x, cur_y = 0, 0
        while i < len(s):
            next_x, next_y = h_m[s[i]]
            # print("{} {} {}".format([cur_x, cur_y], [next_x, next_y], s[i]))
            move_cost = (abs(cur_x - next_x) + abs(cur_y - next_y)) * x
            dir_cost = 0 if cur_x == next_x or cur_y == next_y else y
            click_cost = z
            cost += move_cost + dir_cost + click_cost
            i += 1
            cur_x, cur_y = next_x, next_y
            # print(cost)
        return cost


if __name__ == "__main__":
    line = sys.stdin.readline().strip()
    n, m, x, y, z = list(map(int, line.split()))
    maze = []
    h_m = {}
    for tt in range(n):
        line = sys.stdin.readline().strip()
        maze.append(line)
    s = sys.stdin.readline().strip()
    for i in range(n):
        for j in range(m):
            h_m[maze[i][j]] = (i, j)
    sol = Solution()
    print(sol.get_cost(h_m, s, x, y, z))
