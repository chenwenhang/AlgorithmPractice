package company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 19:03 3/30/2020
 * @Modified by:
 */
public class NumberOfChicken {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        long[] a = new long[n];
        long num = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[j] += k;
            }
            a[n - 1] /= 2;
            Arrays.sort(a);
        }
        for (int i = 0; i < n; i++) {
            num += a[i];
        }
        System.out.println(num);
    }
}















