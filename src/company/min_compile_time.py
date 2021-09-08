import sys
from typing import List


class Node:
    def __init__(self, id, val):
        self.id = id
        self.val = val
        self.children = []


class Solution:
    def __init__(self, target):
        self.target = target

    def get_res(self, nodes: List[Node]):
        return self.get_max_route(nodes, target)

    def get_max_route(self, nodes: List[Node], cur):
        # print(nodes[cur].id)
        # print(nodes[cur].val)
        # print(nodes[cur].children)
        if nodes[cur].children == []:
            return nodes[cur].val
        else:
            max_val = 0
            for id in nodes[cur].children:
                chi_val = self.get_max_route(nodes, id)
                max_val = max_val if max_val > chi_val else chi_val
            return max_val + nodes[cur].val


if __name__ == "__main__":
    # 输入这么恶心，真有你的。
    has_tar = False
    target = 0
    i = 1
    nodes = [Node(-1, -1) for _ in range(50001)]
    for line in sys.stdin:
        if not has_tar:
            target = int(line[6:])
            has_tar = True
            continue
        values = list(map(str, line.split(",")))
        if values == ['\n']:
            break
        id = int(values[0][6:])
        val = int(values[1])
        node = Node(id, val)
        nodes[i] = node
        i += 1
        for i in range(2, len(values)):
            cid = int(values[i][6:])
            node.children.append(cid)
    sol = Solution(target)
    print(sol.get_res(nodes))
