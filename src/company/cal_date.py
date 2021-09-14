import time
import datetime


def get_days_to_birthday(birthday):
    now_time = time.localtime(time.time())
    date_now = datetime.datetime(now_time[0], now_time[1], now_time[2])

    # 获取今年生日日期
    birthday = str(date_now.year) + birthday[4:]
    compare_time = time.strptime(birthday, "%Y-%m-%d")
    date_birth = datetime.datetime(compare_time[0], compare_time[1], compare_time[2])

    diff_days = (date_birth - date_now).days
    if diff_days < 0:
        return "今年生日已经过去了 {} 天".format(abs(diff_days))
    else:
        return "距离今年的生日还有 {} 天".format(diff_days)


if __name__ == "__main__":
    print(get_days_to_birthday("1997-09-11"))
