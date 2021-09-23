# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
from collections import deque


def solution(B):
    arr = [["." for i in range(len(B[0]))] for j in range(len(B))]
    mark = [[False for i in range(len(B[0]))] for j in range(len(B))]
    start = []
    end = [len(B) - 1, len(B[0]) - 1]
    # 构造地图
    for i in range(len(arr)):
        for j in range(len(arr[0])):
            if B[i][j] == "A":
                start = [i, j]
            elif B[i][j] == "X":
                arr[i][j] = "X"
            elif B[i][j] == "^":
                arr[i][j] = "X"
                for a in range(i - 1, -1, -1):
                    if B[a][j] not in ["X", "^", "v", ">", "<"]:
                        arr[a][j] = "X"
                    else:
                        break
            elif B[i][j] == "v":
                arr[i][j] = "X"
                for a in range(i + 1, len(arr)):
                    if B[a][j] not in ["X", "^", "v", ">", "<"]:
                        arr[a][j] = "X"
                    else:
                        break
            elif B[i][j] == ">":
                arr[i][j] = "X"
                for b in range(j + 1, len(arr[0])):
                    if B[i][b] not in ["X", "^", "v", ">", "<"]:
                        arr[i][b] = "X"
                    else:
                        break
            elif B[i][j] == "<":
                arr[i][j] = "X"
                for b in range(j - 1, -1, -1):
                    if B[i][b] not in ["X", "^", "v", ">", "<"]:
                        arr[i][b] = "X"
                    else:
                        break
    # for item in arr:
    #     print(item)
    # print(start)
    # 开始寻路
    q = deque([start])
    while q:
        node = q.popleft()
        x, y = node
        if node == end and arr[x][y] == ".":
            return True
        mark[x][y] = True
        if x - 1 >= 0 and arr[x - 1][y] == "." and not mark[x - 1][y]:
            q.append([x - 1, y])
        if x + 1 < len(arr) and arr[x + 1][y] == "." and not mark[x + 1][y]:
            q.append([x + 1, y])
        if y - 1 >= 0 and arr[x][y - 1] == "." and not mark[x][y - 1]:
            q.append([x, y - 1])
        if y + 1 < len(arr[0]) and arr[x][y + 1] == "." and not mark[x][y + 1]:
            q.append([x, y + 1])
    return False


print(solution(["X.....>", "..v..X.", ".>..X..", "A......"]))
print(solution(["...Xv", "AX..^", ".XX.."]))
print(solution(["...", ">.A"]))
print(solution(["A.v", "..."]))
