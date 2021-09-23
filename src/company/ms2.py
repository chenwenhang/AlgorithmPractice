# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(S):
    res = 0
    total = 0
    h_m = {
        # 0 3 6 9
        0: 4,
        # 2 5 8
        1: 3,
        # 1 4 7
        2: 3
    }
    for i in S:
        total += int(i)
    for i in S:
        num = total - int(i)
        res += h_m[num % 3]
    if total % 3 == 0:
        res -= (len(S) - 1)
    print(res)
    return res


solution("23")
solution("0081")
solution("81")
solution("022")
solution("333")
