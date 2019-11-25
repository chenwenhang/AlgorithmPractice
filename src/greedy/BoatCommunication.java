package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Wenhang Chen
 * @Description:海面上有一些船需要与陆地进行通信，需要在海岸线上布置一些基站。现将问题抽象为，在x轴上方，给出N条船的坐标𝑝_1,𝑝_2,…,𝑝_𝑁，𝑝_𝑖=(𝑥_𝑖,𝑦_𝑖)，𝑥_𝑖≥0, 𝑦_𝑖≤d,1≤𝑖≤𝑁，在x轴上安放的基站可以覆盖半径为d的区域内的所有点，问在x轴上至少要安放几个点才可以将x轴上方的点都覆盖起来。试设计一个算法求解该问题，并分析算法的正确性。
 * @Date: Created in 20:17 11/13/2019
 * @Modified by:
 */
public class BoatCommunication {
    public int getMinPoints(double[][] points, int d) {
        if (points.length == 0) return 0;
        int n = points.length;
        int minPoints = 0;
        // 先按照横坐标排序
        Arrays.sort(points, new Comparator<double[]>() {
            @Override
            public int compare(double[] a, double[] b) {
                if (a[0] == b[0])
                    return 0;
                else
                    return a[0] > b[0] ? 1 : -1;
            }
        });
        for (int i = 0; i < n; i++) {
            minPoints++;
            double x = points[i][0];
            double y = points[i][1];
            x += Math.sqrt(d * d - y * y);
            // 基站坐标为(x, 0)
            do {
                i++;
                if (i >= n)
                    break;
                // 从左往右，每次框住尽可能多的点
            } while ((points[i][0] - x) * (points[i][0] - x) + points[i][1] * points[i][1] <= d * d);
        }
        return minPoints;
    }
}
