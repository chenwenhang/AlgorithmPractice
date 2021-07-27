# 1.假设a区间[0,1],b区间[0,2]，则b区间可以完全覆盖a区间，
# 给你任意多的区间，判断是否存在任意两个区间是可以完全覆盖的（存在覆盖即可）输出true ，false

import sys

if __name__ == "__main__":
    flag = False
    # 读取第一行的n
    n = int(sys.stdin.readline().strip())
    nums = []
    for i in range(n):
        # 读取每一行
        line = sys.stdin.readline().strip()
        # 把每一行的数字分隔后转化成int列表
        values = list(map(int, line.split()))
        nums.append(values)
    nums.sort(key=lambda x: [x[0], -x[1]])
    max_num = nums[0][0]
    # print(nums)
    for arr in nums:
        if max_num > arr[1]:
            print("true")
            flag = True
            break
        else:
            max_num = arr[1]
    if not flag:
        print("false")
