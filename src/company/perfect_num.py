import sys


class Solution:
    def get_perfect_num(self, x: str):
        ls = [-1] + [int(x) for x in x]
        for i in range(len(ls) - 1, 0, -1):
            if ls[i] <= 0 and ls[i - 1] != -1:
                ls[i] = 9
                ls[i - 1] -= 1
        i = 0
        # 出现第一个大于3的数的话，后面全部为3
        while i < len(ls) and ls[i] <= 3:
            i += 1
        while i < len(ls):
            ls[i] = 3
            i += 1
        for i in range(len(ls) - 1, 0, -1):
            if ls[i] <= 3 < ls[i - 1]:
                ls[i] = 3
            else:
                ls[i] = ls[i] if ls[i] <= 3 else 3
        i = 0
        while ls[i] <= 0:
            i += 1
        return "".join(list(map(str, ls[i:])))


if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    for tt in range(n):
        num = sys.stdin.readline().strip()
        sol = Solution()
        print(sol.get_perfect_num(num))
