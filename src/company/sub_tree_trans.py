# 交换左右子树，输出中序遍历
import sys


class Node:
    def __init__(self, num):
        self.num = num
        self.left = None
        self.right = None


class Solution():
    def __init__(self):
        self.res = []

    def get_res(self, node: Node):
        self.reserval(node)
        values = list(map(str, self.res))
        return " ".join(values)

    def reserval(self, node: Node):
        if not node:
            return
        if node.left:
            self.reserval(node.left)
        self.res.append(node.num)
        if node.right:
            self.reserval(node.right)


if __name__ == "__main__":
    line = sys.stdin.readline().strip()
    values = list(map(int, line.split()))
    n, m, k = values
    ls = [Node(i) for i in range(n + 1)]
    ls[0] = None
    for t in range(n):
        line = sys.stdin.readline().strip()
        values = list(map(int, line.split()))
        # print(values)
        left_num, right_num = values
        ls[t + 1].left = ls[left_num]
        ls[t + 1].right = ls[right_num]

    line = sys.stdin.readline().strip()
    values = list(map(int, line.split()))
    for v in values:
        ls[v].left, ls[v].right = ls[v].right, ls[v].left

    sol = Solution()
    print(sol.get_res(ls[k]))
