# 两元素和为X。给定一个由n 个实数构成的集合S 和另一个实数x，判断S 中是否有两个元素的和为x
# 分治
def merge(a, b):
    result = []
    i = j = 0
    while i < len(a) and j < len(b):
        if a[i] < b[j]:
            result.append(a[i])
            i += 1
        else:
            result.append(b[j])
            j += 1
    result += a[i:]
    result += b[j:]
    return result


def sorts(data):
    length = len(data)
    if length <= 1:
        return data
    mid = length // 2
    a = sorts(data[:mid])
    b = sorts(data[mid:])
    return merge(a, b)


def binary_search(left, right, A, key):
    if left > right or key < A[left] or key > A[right]:
        return -1
    mid = (left + right) // 2
    if key == A[mid]:
        return mid
    elif key < A[mid]:
        return binary_search(left, mid - 1, A, key)
    else:
        return binary_search(mid + 1, right, A, key)


def judge_sum_equal_x(A, x):
    A = sorts(A)
    # print(A)
    for i in range(0, len(A)):
        z = x - A[i]
        if binary_search(0, len(A) - 1, A, z) != -1:
            return True
    return False

if __name__ == "__main__":
    A = [1, 5, 9, 7, 6, 4, 3]
    print(judge_sum_equal_x(A, 6))
