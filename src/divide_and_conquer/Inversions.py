# 求逆序对
# 有一实数序列𝑎_1,𝑎_2,…,𝑎_𝑁，若𝑖<𝑗 且 𝑎_𝑖>𝑎_𝑗，则(𝑎_𝑖,𝑎_𝑗)构成了一个逆序对，请使用分治方法求整个序列中逆序对个数，并分析算法的时间复杂性。
# 分治
def merge_count(list):
    if len(list) <= 1:
        return list, 0
    mid = len(list) // 2
    left_li, left_cont = merge_count(list[:mid])
    right_li, right_cont = merge_count(list[mid:])
    count = left_cont + right_cont

    left_p, right_p = 0, 0
    result = []
    while left_p < len(left_li) and right_p < len(right_li):
        if left_li[left_p] > right_li[right_p]:
            result.append(left_li[left_p])
            count += len(right_li[right_p:])
            left_p += 1
        else:
            result.append(right_li[right_p])
            right_p += 1
    result += left_li[left_p:]
    result += right_li[right_p:]
    return result, count


if __name__ == "__main__":
    mylist = [5, 2, 4, 3, 1]
    _, count = merge_count(mylist)
    print(count)
