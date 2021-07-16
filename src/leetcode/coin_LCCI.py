class Solution:
    def waysToChange(self, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(5)]
        for i in range(5):
            dp[i][0] =