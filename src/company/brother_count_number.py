# 获取两个日期间的，当月的第一天是周一，这种情况出现了多少次
import datetime
import sys

if __name__ == "__main__":
    line = sys.stdin.readline().strip()
    s_y, e_y = list(map(int, line.split()))
    cnt = 0
    for year in range(s_y, e_y + 1):
        for month in range(1, 13):
            month = "%02d" % month
            weekday = datetime.datetime.strptime("{}{}{}".format(year, month, "01"), "%Y%m%d").weekday()
            if weekday == 0:
                cnt += 1
    print(cnt)
