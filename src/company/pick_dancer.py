# 题目描述
# 悉尼歌剧院准备举办一场舞蹈演出.
# 于是教练去挑选舞蹈演员
# 他让 n 名舞蹈演员站成一排。每个演员都有一个 独一无二 的身高.
# 每 3 个演员可以组成一个小组，分组规则如下：
# 从队伍中选出位置分别为的j,k,l的 3 名演员，他们的身高分别为分别为 height[j],  height[k],  height[l].
# 由于教练是个强迫症,所以舞蹈小队需要满足： height[j] < height[k] < height[l] 或者 height[j] > height[k] > height[l],
# 其中  0 <= j < k < l < n.
# 请你返回按上述条件可以组建的舞蹈小队。每个演员都可以是多个舞蹈小队的一部分。
# 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
#
# 输入
# [1,5,3,2,4]
#
# 输出
# 3
#
# 我们可以组建三个舞蹈小队  (1,3,4)、(1,2,4)、(5,3,2)


from typing import List


class Solution:
    def __init__(self):
        self.res = 0

    def TeamNums(self, height: List[int]) -> int:
        for i in range(0, len(height)):
            self.reversal(height, float("-inf"), i, 1, True)
            self.reversal(height, float("inf"), i, 1, False)
        # print(self.res)
        return self.res

    def reversal(self, height, last, pos, cnt, need_up):
        # print("last: {}".format(last))
        # print("pos: {}".format(height[pos]))
        # print("cnt: {}".format(cnt))
        # print()

        if need_up:
            if last < height[pos]:
                if cnt == 3:
                    self.res += 1
                    return
                for i in range(pos + 1, len(height)):
                    self.reversal(height, height[pos], i, cnt + 1, need_up)
        else:
            if last > height[pos]:
                if cnt == 3:
                    self.res += 1
                    return
                for i in range(pos + 1, len(height)):
                    self.reversal(height, height[pos], i, cnt + 1, need_up)


sol = Solution()
sol.TeamNums([1, 5, 3, 2, 4])
