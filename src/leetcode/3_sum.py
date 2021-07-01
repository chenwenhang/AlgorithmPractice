from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        rev = [-num for num in nums]
        # print(nums)
        res = []
        for pos in range(0, len(nums) - 2):
            if nums[pos] == nums[pos - 1] and pos - 1 >= 0:
                continue
            start, end = pos + 1, len(nums) - 1
            while pos < start < end < len(nums):
                if nums[start] > rev[pos] or nums[end] < nums[pos]:
                    break
                if nums[start] + nums[end] < rev[pos]:
                    start += 1
                elif nums[start] + nums[end] > rev[pos]:
                    end -= 1
                else:
                    res.append([nums[pos], nums[start], nums[end]])
                    start += 1
        res = list(set([tuple(item) for item in res]))
        res = [list(v) for v in res]
        return res


sol = Solution()
# sol.threeSum([-2, 0, 1, 1, 2])
# sol.threeSum([-1, 0, 1, 2, -1, -4])
# sol.threeSum([0, 0, 0, 0, 0])
sol.threeSum(
    [34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66,
     46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49])
