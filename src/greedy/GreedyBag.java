package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Wenhang Chen
 * @Description:背包问题，物品可部分装入，求背包可装最大价值
 * @Date: Created in 20:00 11/12/2019
 * @Modified by:
 */
public class GreedyBag {
    public double getMaxValue(double[] value, double[] weight, int M) {
        // 先装单位价值最高的，最后一次无法放下整个物体时，放部分
        double maxValue = 0;
        double[][] goods = new double[value.length][3];
        for (int i = 0; i < value.length; i++) {
            goods[i][0] = weight[i];
            goods[i][1] = value[i];
            goods[i][2] = value[i] / weight[i];
        }
        // 先按照单位价值排序
        Arrays.sort(goods, new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                if (a[2] == b[2]) {
                    return 0;
                }
                return a[2] - b[2] > 0 ? 1 : -1;
            }
        });
        // 装入背包
        for (int i = 0; M > 0; i++) {
            if (goods[i][0] < M) {
                maxValue += goods[i][1];
                M -= goods[i][0];
            } else {
                maxValue += goods[i][2] * M;
                M = 0;
            }
        }
        return maxValue;
    }

}
