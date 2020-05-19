package other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 19:56 5/19/2020
 * @Modified by:
 */
public class SecondGap {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String start = sc.nextLine();
        String end = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long startDate = sdf.parse(start).getTime();
        long endDate = sdf.parse(end).getTime();
        System.out.println((endDate - startDate) / 60000);
    }
}
