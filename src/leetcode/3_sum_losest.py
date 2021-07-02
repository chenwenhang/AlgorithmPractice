from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        rev = [target - num for num in nums]
        min_gap = 10 ** 5
        total = 0
        for pos in range(0, len(nums) - 2):
            if nums[pos] == nums[pos - 1] and pos - 1 >= 0:
                continue
            start, end = pos + 1, len(nums) - 1
            while pos < start < end < len(nums):
                if min_gap > abs(rev[pos] - nums[start] - nums[end]):
                    min_gap = abs(rev[pos] - nums[start] - nums[end])
                    total = nums[start] + nums[end] - rev[pos] + target
                if nums[start] + nums[end] < rev[pos]:
                    start += 1
                elif nums[start] + nums[end] > rev[pos]:
                    end -= 1
                else:
                    return target
        return total
