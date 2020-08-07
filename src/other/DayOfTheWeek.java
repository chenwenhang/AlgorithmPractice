package other;

/**
 * @Author: Wenhang Chen
 * @Description:给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * <p>
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 * <p>
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 * <p>
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 * @Date: Created in 14:07 8/7/2020
 * @Modified by:
 */
public class DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        int sumOfDays = 0;
        int[] sumOfYears = new int[131];
        int[] sumOfMonth = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int[] sumOfLeapMonth = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        for (int i = 1; i < 131; ++i) {
            sumOfYears[i] = sumOfYears[i - 1] + (isLeapYear(i + 1969) ? 366 : 365);
        }
        for (int i = 1; i < 131; ++i) {
            sumOfYears[i] = sumOfYears[i - 1] + (isLeapYear(i + 1969) ? 366 : 365);
        }
        sumOfDays = sumOfYears[year - 1970] + (isLeapYear(year) ? sumOfLeapMonth[month - 1] : sumOfMonth[month - 1]) + day;
        String result[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return result[(sumOfDays + 2) % 7];

    }

    public boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}























