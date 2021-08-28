# 题目描述：
# 为了更好的项目协作与管理，小易决定将学到的日特图知识用于mini项目时间预估，小易先把项目中
# 每一项工作以任务的形式列举出来，每项任务有一个预计花费时间与前置任务表，必须完成了该任务
# 的前置任务才能着手去做该任务，作为经验PM,小易把任务划分得并井有条，保证没有前置任务或者前
# 置任务全数完成的任务，都可以同时进行。小易给出了这样一个任务表，请作为程序的你计算需要至少
# 多长时间才能完成所有任务。
# 输入描述：
# 输入第一行为一个正整数T,表示数据组数。对于接下来每组数据，第一行为一个正整数N,表示一共
# 有N项任务。接下来N行，每行先有两个整数Di和Ki,表示完成第1个任务的预计花费时间为Di天，该
# 任务有Ki个前置任务，之后为Ki个整数Mj,表示第Mj个任务是第1个任务的前置任务，
# 数据范围：
# 对于所有数据，满足1<=T<=3, 1<=N,MJ<=100000,0 <=Di <=1000, 0 <=sum (Ki) <aN*2.
# 输入
# 2
# 3
# 5 0
# 10 1 1
# 15 1 1
# 4
# 3 0
# 4 0
# 7 1 1
# 6 2 1 2
# 输出
# 20
# 10

import sys
from typing import List


class Node:
    def __init__(self, idx, time: int, st: set):
        self.idx = idx
        self.time = time
        self.pre_set = st


class Solution:
    def get_max_time(self, ls: List[Node]) -> int:
        fin_ls = [0 for _ in range(len(ls) + 1)]
        ok_set = set([])
        # 初始化
        for i in range(len(ls) - 1, -1, -1):
            if not ls[i].pre_set:
                fin_ls[ls[i].idx] = ls[i].time + 0
                ok_set.add(ls[i].idx)
                del ls[i]
        # 开始执行
        while ls:
            for i in range(len(ls) - 1, -1, -1):
                if ls[i].pre_set.issubset(ok_set):
                    fin_ls[ls[i].idx] = ls[i].time + max([fin_ls[idx] for idx in ls[i].pre_set])
                    ok_set.add(i)
                    del ls[i]
        return max(fin_ls)


if __name__ == "__main__":
    T = int(sys.stdin.readline().strip())
    for tt in range(T):
        n = int(sys.stdin.readline().strip())
        ls = []
        for i in range(1, n + 1):
            line = sys.stdin.readline().strip()
            values = list(map(int, line.split()))
            if values[1] == 0:
                ls.append(Node(i, values[0], set([])))
            else:
                ls.append(Node(i, values[0], set(values[2:])))
        sol = Solution()
        print(sol.get_max_time(ls))
