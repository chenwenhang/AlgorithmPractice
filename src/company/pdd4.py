# 4.给定数字0-9的个数，求出该所有数字如何组合得到的乘积最大：
# 例如：0 4 0 0 0 0 0 0 0 0：
# 输出：121（解释：因为有4个1，最大组成 11 * 11 = 121）
#
# 例如：2 3 0 1 0 0 0 0 0 0：
# 输出：34100（解释：1个3，2个0，三个1 最大组成3100 * 11 = 34100）
import sys

if __name__ == "__main__":
    line = sys.stdin.readline().strip()
    # 把每一行的数字分隔后转化成int列表
    values = list(map(int, line.split()))
    nums = []
    for i in range(len(values) - 1, -1, -1):
        nums += [i] * values[i]
    # print(nums)

    arr1 = []
    arr2 = []

    flag = 0
    while nums:
        if flag == 0:
            if len(nums) >= 2:
                n1 = nums.pop(0)
                n2 = nums.pop(0)
                arr1.append(n1)
                arr2.append(n2)
                if n1 > n2:
                    flag = 1
            else:
                arr1.append(nums.pop(0))
        elif flag == 1:
            if len(nums) >= 2:
                n1 = nums.pop(0)
                n2 = nums.pop(0)
                arr2.append(n1)
                arr1.append(n2)
            else:
                arr2.append(nums.pop(0))
    n1 = int("".join(list(map(str, arr1))))
    n2 = int("".join(list(map(str, arr2))))
    print(n1 * n2)
