from typing import List


class Solution:
    def __init__(self):
        self.res = [[]]

    def subsets(self, nums: List[int]) -> List[List[int]]:
        for i in range(len(nums)):
            self.recursive(nums, [], i)
        # print(self.res)
        return self.res

    def recursive(self, nums: List[int], cur_nums: List[int], pos: int):
        if pos >= len(nums):
            return
        cur_nums.append(nums[pos])
        self.res.append(cur_nums[:])
        for i in range(pos + 1, len(nums)):
            self.recursive(nums, cur_nums, i)
        cur_nums.pop()
        return


sol = Solution()
sol.subsets([1, 2, 3])
