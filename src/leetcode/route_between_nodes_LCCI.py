from collections import defaultdict, deque
from typing import List


class Solution:
    def findWhetherExistsPath(self, n: int, graph: List[List[int]], start: int, target: int) -> bool:
        routs = defaultdict(set)
        for item in graph:
            routs[item[0]].add(item[1])
        q = deque([start])
        while q and routs:
            node = q.popleft()
            for point in routs[node]:
                if point == target:
                    return True
                else:
                    q.append(point)
            routs.pop(node)
        return False
