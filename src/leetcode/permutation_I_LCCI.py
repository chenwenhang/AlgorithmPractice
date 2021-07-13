from typing import List


class Solution:
    def __init__(self):
        self.res = []

    def permutation(self, S: str) -> List[str]:
        self.recursive([], list(S))
        print(self.res)
        return self.res

    def recursive(self, cur_s: List[str], remain: List[str]):
        if not remain:
            self.res.append("".join(cur_s))
            return
        for i in range(len(remain)):
            cur_s.append(remain[i])
            self.recursive(cur_s, remain[:i] + remain[i + 1:])
            cur_s.pop()


sol = Solution()
sol.permutation("qwe")
