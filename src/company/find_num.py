# 小美和小团在玩游戏。小美将会给出n个大小在1到n
# 之间（包括1和n）的整数，然后小美会再告诉小团一个整数k，小团需要找到一个最小的整数x满足以下条件：
# 整数x的大小在1到n之间（包括1和n）
# 在小美给出的n个整数中，恰好有k个数严格比x小
#
# 输入描述
# 第一行是一个数T，表示有T组数据。
# 对于每组数据：
# 第一行有两个整数n和k，分别表示小美将会给出n个数以及她给出的整数k。
# 接下来一行有n个用空格隔开的正整数，表示小美给出的n个正整数。
#
# 输出描述
# 对于每组数据：
# 如果存在满足要求的数x，第一行先输出“YES”（不含引号），第二行输出数x的值。
# 如果不存在满足要求的数x，输出“NO”（不含引号）。

import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    for tt in range(n):
        line = sys.stdin.readline().strip()
        nk_ls = list(map(int, line.split()))
        n, k = nk_ls
        line = sys.stdin.readline().strip()
        values = list(map(int, line.split()))
        values.sort()
        if k == n:
            if values[n - 1] < n:
                print("YES")
                print(values[n - 1] + 1)
            else:
                print("NO")
        elif k == 0:
            print("YES")
            print(1)
        elif k < n and values[k - 1] < values[k]:
            print("YES")
            print(values[k - 1] + 1)
        else:
            print("NO")
