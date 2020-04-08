package company;

import java.util.*;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 20:00 4/7/2020
 * @Modified by:
 */
public class ViralTransmission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int f = sc.nextInt();
        boolean[] virus = new boolean[n];
        int[] flag = new int[n];
        virus[f] = true;
        for (int i = 0; i < m; i++) {
            int q = sc.nextInt();
            boolean signal = false;
            for (int j = 0; j < q; j++) {
                flag[j] = sc.nextInt();
                if (virus[flag[j]]) signal = true;
            }
            if (signal) {
                for (int j = 0; j < q; j++) {
                    virus[flag[j]] = true;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (virus[i]) sum++;
        }
        System.out.println(sum);
    }
}
