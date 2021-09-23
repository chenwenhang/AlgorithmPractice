from typing import List


class Solution:
    def __init__(self):
        self.res = []

    def permutation(self, seed: List[str], size: int):
        mark = [False for _ in range(len(seed))]
        self.dfs(seed, mark, [], size)
        return self.res

    def dfs(self, seed: List[str], mark: List[bool], cur: List[str], size: int):
        if len(cur) == size:
            self.res.append("".join(cur))
            return
        for i in range(len(seed)):
            if not mark[i]:
                mark[i] = True
                cur.append(seed[i])
                self.dfs(seed, mark, cur, size)
                cur.pop()
                mark[i] = False


sol = Solution()
sol.permutation(['0', '1', '2'], 2)
soll = Solution()
soll.permutation(['0', '1', '2', '3', 'A'], 3)
