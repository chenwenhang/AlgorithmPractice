class Solution:
    def waysToChange(self, n: int) -> int:
        # dp[i][j] 表示使用前i种面值的钱，组成总价为j一共有多少种
        dp = [[0] * (n + 1) for _ in range(4)]
        coins = [1, 5, 10, 25]

        for i in range(4):
            dp[i][0] = 1
        for i in range(n + 1):
            dp[0][i] = 1

        for i in range(1, 4):
            for j in range(1, n + 1):
                if j >= coins[i]:
                    # dp[i][j]等于：
                    # 仅使用i-1种货币组成总价为j的情况个数，加上
                    # 使用所有i种货币，组成总价为j-coins[i]的情况个数
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i]]) % 1000000007
                else:
                    dp[i][j] = dp[i - 1][j]
        # print(dp[3][n])
        return dp[3][n]


sol = Solution()
sol.waysToChange(5)
