import sys
import math

if __name__ == "__main__":
    # 读取第一行的n
    tt = int(sys.stdin.readline().strip())

    for t in range(tt):
        n = int(sys.stdin.readline().strip())
        min_val = None
        min_idx = None
        for i in range(n):
            line = sys.stdin.readline().strip()
            values = list(map(int, line.split()))
            x1, y1, x2, y2, s = values
            # ppp = math.sqrt(((x1 - x2) ** 2 + (y1 - y2) ** 2)) * s / abs(x1 - x2)
            # print(ppp)
            price = math.sqrt(((x1 - x2) ** 2 + (y1 - y2) ** 2)) * s / abs(x1 - x2)
            if min_val is not None:
                if price < min_val:
                    min_val = price
                    min_idx = i + 1
            else:
                min_val = price
                min_idx = i + 1
        print(min_idx)
