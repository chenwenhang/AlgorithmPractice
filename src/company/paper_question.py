# 题目描述
# 一群小朋友围成一圈准备开始画画，现在老师需要给这些孩子发纸张；
# 规则是如果一个小朋友的年龄比自己旁边的人大，那么这个小朋友就必须分到比身旁孩子更多的纸张；
# 所有孩子至少要有一个纸张，请帮助老师设计一个算法，算出最少需要多少张纸。
# 备注：假设小朋友的总数量不会超过100个；每个小朋友至少要求至少有一张纸；
# 当且仅当年龄大于相邻小朋友时，才会要求纸张数量更多（年龄相等的情况下，允许小于或者等于）。
# 输入描述：
# 输入是一个数组，表示孩子的年龄，以空格隔并，举例如下：4 4 5代表3个小朋友，年龄分别是4岁，4岁，5岁
# 输出描述：
# 6
# 输出是最少需要的纸张的数量，以上述的输入为例，则最少需要1+1+2=4

import sys
from typing import List


class Solution:
    def get_min_paper(self, age: List[int]) -> int:
        if len(age) == 1:
            return 1
        if len(age) == 2:
            return 3
        # 初始化
        paper = [0 for _ in range(len(age))]
        if age[-1] >= age[0] and age[0] <= age[1]:
            paper[0] = 1
        if age[-2] >= age[-1] and age[-1] <= age[0]:
            paper[-1] = 1
        for i in range(1, len(age) - 1):
            if age[i - 1] >= age[i] and age[i] <= age[i + 1]:
                paper[i] = 1
        # 调整
        i = 0
        time = 0
        while time <= len(age) + 1:
            time += 1
            i = 0 if i == len(age) else i
            if age[i] > age[i - 1]:
                if paper[i] <= paper[i - 1]:
                    paper[i] = paper[i - 1] + 1
                    time = 0
            i += 1

        i = len(age) - 1
        time = 0
        while time <= len(age) + 1:
            time += 1
            i = len(age) - 1 if i == -1 else i
            if age[i - 1] > age[i]:
                if paper[i - 1] <= paper[i]:
                    paper[i - 1] = paper[i] + 1
                    time = 0
            i -= 1
        # print(paper)
        # print(sum(paper))
        return sum(paper)


line = sys.stdin.readline().strip()
values = list(map(int, line.split()))
sol = Solution()
sol.get_min_paper(values)
