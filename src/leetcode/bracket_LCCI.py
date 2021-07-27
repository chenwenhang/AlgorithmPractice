from typing import List


class Solution:
    def __init__(self):
        self.res = []

    def generateParenthesis(self, n: int) -> List[str]:
        self.recursive(n, n, [])
        # print(self.res)
        return self.res

    def recursive(self, q: int, p: int, cur_s: List[str]):
        if q == 0 and p == 0:
            self.res.append(''.join(cur_s))
            return
        if 0 <= q - 1 <= p:
            cur_s.append("(")
            self.recursive(q - 1, p, cur_s)
            cur_s.pop()
        if p - 1 >= 0 and q <= p - 1:
            cur_s.append(")")
            self.recursive(q, p - 1, cur_s)
            cur_s.pop()


sol = Solution()
sol.generateParenthesis(3)
