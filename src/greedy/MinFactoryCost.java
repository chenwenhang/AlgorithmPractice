package greedy;

import java.util.Arrays;

/**
 * @Author: Wenhang Chen
 * @Description:某公司有个工厂和仓库。由于原材料等价格波动，工厂每个月的生产成本也会波动，令第𝑖个月产品的单位生产成本为𝑐_𝑖（该月生产一个产品的成本为𝑐_𝑖）。仓库储存产品的也有成本，假设每个月产品的单位储存成本为固定值1（存储一个产品一个月的成本为1）。令第𝑖个月需要供应给客户的产品数量为𝑦_𝑖，仓库里的和生产的产品均可供应给客户。假设仓库的容量无限大，供应给客户剩余的产品可储存在仓库中。若已知𝑛个月中各月的单位生产成本𝑐_𝑖、以及产品供应量𝑦_𝑖，设计一算法决策每个月的产品生产数量𝑥_𝑖，使得𝑛个月的总成本最低。例如：𝑛=3，𝑐_𝑖:2,5,3，𝑦_𝑖:2,4,5，则𝑥_𝑖:6,0,5，即第1个月生产6个供应2个（代价2×2=4），储存4个供应给第2个月（代价(2+1)×4=12），第3个月生产5个供应5个（代价3×5=15），使总成本4+12+15=31最小。
 * @Date: Created in 18:58 11/18/2019
 * @Modified by:
 */
public class MinFactoryCost {
    public static int[] getMinFactoryCost(int n, int[] cost, int[] need) {
        int[] num = new int[n];
        int i = 0, j = 0;
        for (i = 0; i < n; i++) {
            // 第i个月的需求决定在哪个月买，初始化为第i个月报销
            int month = i;
            // 第j个月提前买
            for (j = 0; j < i; j++) {
                // preCost为第j个月的成本加上存储i-j个月的消耗
                int preCost = cost[j] + i - j;
                // 如果提前买更便宜
                if (preCost < cost[i]) {
                    month = j;
                }
            }
            // 此时month为成本最低的那个月
            num[month] += need[i];
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMinFactoryCost(3, new int[]{2, 5, 3}, new int[]{2, 4, 5})));
    }

}
