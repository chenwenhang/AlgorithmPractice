from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        self.recursive("", n, n, res)
        # print(res)
        return res

    def recursive(self, s: str, n: int, m: int, res: List[str]):
        # 剪枝
        if n > m:
            return
        if n == 0 and m == 0:
            res.append(s)
            return
        if n > 0:
            self.recursive(s + "(", n - 1, m, res)
        if m > 0:
            self.recursive(s + ")", n, m - 1, res)


sol = Solution()
sol.generateParenthesis(3)
