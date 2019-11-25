# 给定一个数组，数组中元素按从小到大排好序，现将数组中元素循环右移若干位，请设计一算法，计算出循环右移了多少位。
# 分治
def get_cycle_shift_bit(left, right, A):
    if left == right:
        return 0
    if right - left == 1:
        if A[left] > A[right]:
            return right
        else:
            return 0
    mid = (left + right) // 2
    left_max = get_cycle_shift_bit(left, mid, A)
    right_max = get_cycle_shift_bit(mid, right, A)
    return max(left_max, right_max)

if __name__ == "__main__":
    A = [0, 1, 2, 4, -2, -1]
    print(get_cycle_shift_bit(0, len(A) - 1, A))
