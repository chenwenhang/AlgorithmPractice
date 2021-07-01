from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_vol = 0
        start = 0
        end = len(height) - 1
        while start < end:
            if height[start] <= height[end]:
                max_vol = max_vol if max_vol >= (end - start) * height[start] else (end - start) * height[start]
                start += 1
            else:
                max_vol = max_vol if max_vol >= (end - start) * height[end] else (end - start) * height[end]
                end -= 1
        return max_vol
