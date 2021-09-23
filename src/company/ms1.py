# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(N, K):
    N = str(N)
    a = int(N[0])
    b = int(N[1])
    c = int(N[2])
    while K > 0 and not (a == b == c == 9):
        K -= 1
        if a < 9:
            a += 1
        elif b < 9:
            b += 1
        elif c < 9:
            c += 1
    print(int("{}{}{}".format(a, b, c)))
    return int("{}{}{}".format(a, b, c))


solution(512, 10)
solution(191, 4)
solution(285, 20)
solution(100, 20)
