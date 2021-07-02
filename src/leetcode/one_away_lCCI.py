class Solution:
    def oneEditAway(self, first: str, second: str) -> bool:
        dp = [[0] * (len(first) + 1) for _ in range(len(second) + 1)]
        n1 = len(first) + 1
        n2 = len(second) + 1
        for i in range(1, n1):
            dp[0][i] = dp[0][i - 1] + 1
        for i in range(1, n2):
            dp[i][0] = dp[i - 1][0] + 1
        for i in range(1, n2):
            for j in range(1, n1):
                if first[j - 1] == second[i - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1
        # print(dp)
        return dp[n2 - 1][n1 - 1] <= 1


sol = Solution()
sol.oneEditAway("pale", "ple")
