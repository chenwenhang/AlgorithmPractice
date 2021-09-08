import sys


class Node:
    def __init__(self, id, val):
        self.id = id
        self.val = val
        self.sum = 0
        self.ab = 0
        self.left = None
        self.right = None


class Solution:
    def __init__(self, root: Node):
        self.root = root
        self.total = 0
        self.best_id = 0
        self.best_ab = -1

    def get_res(self):
        self.cal_sum(self.root)
        self.total = self.root.sum
        self.get_abs(self.root.left)
        self.get_abs(self.root.right)
        return self.best_id

    def get_abs(self, node: Node):
        if node is None:
            return
        node.ab = abs(self.total - 2 * node.sum)
        if self.best_ab < node.ab:
            self.best_id = node.id
            self.best_ab = node.ab
        self.get_abs(node.left)
        self.get_abs(node.right)

    def cal_sum(self, node: Node):
        if node is None:
            return 0
        node.sum = self.cal_sum(node.left) + self.cal_sum(node.right) + node.val
        return node.sum


if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    line = sys.stdin.readline().strip()
    values = list(map(int, line.split()))
    nodes = [Node(i, values[i]) for i in range(len(values))]
    for i in range(n - 1):
        line = sys.stdin.readline().strip()
        parent, child = list(map(int, line.split()))
        if not nodes[parent].left:
            nodes[parent].left = nodes[child]
        else:
            nodes[parent].right = nodes[child]
    sol = Solution(nodes[0])
    print(sol.get_res())
    # for node in nodes:
    #     print("id:{}, val:{}, sum:{}, ab:{}".format(node.id, node.val, node.sum, node.ab))
