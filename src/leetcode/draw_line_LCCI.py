# 找到一个数组中，和为K的连续子数组的个数
from typing import List


class Solution:
    def get_child_arrary(self, matrix: List[int], k: int) -> int:
        num = 0
        # 结果，出现总次数
        res = 0
        # 哈希表，用于存储当前出现的数字次数
        cnt = {}
        for n in matrix:
            num += n
            if num == k:
                res += 1
            elif num - k in cnt:

                res += cnt[num - k]
                # res += cnt[num]
            cnt[num] = cnt.get(num, 0) + 1
        print(res)
        return res


sol = Solution()
sol.get_child_arrary([1, 2, 3], 2)
sol.get_child_arrary([1, 2, 3, 2, 3, 2, 3], 2)
