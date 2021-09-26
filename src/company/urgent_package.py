import sys

if __name__ == "__main__":
    T = int(sys.stdin.readline().strip())
    for tt in range(T):
        line = sys.stdin.readline().strip()
        bsx, bsy, bex, bey, asx, asy, aex, aey = list(map(int, line.split()))
        d_express = (aex - bsx) ** 2 + (aey - bsy) ** 2
        d_alice = (aex - asx) ** 2 + (aey - asy) ** 2
        if d_express < d_alice:
            print("Yes")
        else:
            print("No")
