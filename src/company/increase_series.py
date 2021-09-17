import sys
from typing import List


class Solution:
    def solution(self, nums: List[int], k: int) -> int:
        res = []

        def dfs(nums: List[int], tmp: List[int], k: int) -> None:
            if 0 < len(tmp) <= k:
                res.append(tmp)
            for inx, i in enumerate(nums):
                if not tmp or i > tmp[-1]:
                    dfs(nums[inx + 1:], tmp + [i], k)

        dfs(nums, [], k)
        return len(res) % (2 ** 61 - 1)


line = sys.stdin.readline().strip()
n, k = list(map(int, line.split()))
line = sys.stdin.readline().strip()
values = list(map(int, line.split()))
sol = Solution()
print(sol.solution(values, k))
