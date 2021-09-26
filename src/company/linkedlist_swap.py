import sys
if __name__ == "__main__":
    le = int(sys.stdin.readline().strip())
    line = sys.stdin.readline().strip()
    values = list(map(int, line.split()))
    k = int(sys.stdin.readline().strip())
    total = 0
    for item in values:
        if item == k:
            total += 1
    min_global = float("inf")
    i = 0
    while i < le:
        if values[i] != k:
            i += 1
            continue
        total_tmp = total
        min_tmp = 0
        for j in range(i, le):
            if total_tmp == 0:
                min_global = min_global if min_global < min_tmp else min_tmp
                break
            if values[j] != k:
                min_tmp += 1
                total_tmp -= 1
            else:
                total_tmp -= 1
        if total_tmp == 0:
            min_global = min_global if min_global < min_tmp else min_tmp
        i += 1
    print(min_global)
