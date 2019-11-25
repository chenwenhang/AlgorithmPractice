package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:背包问题：01背包
 * @Date: Created in 19:22 10/19/2019
 * @Modified by:
 */
public class Bag01 {
    int[] weight;// 物品的质量数组
    int[] value;// 物品的价值数组
    int[][] dp;// dp表格
    int max_weight;// 背包容量

    public Bag01(int[] weight, int[] value, int max_weight) {
        this.weight = new int[weight.length + 1];
        this.value = new int[value.length + 1];
        for (int i = 1; i <= weight.length; i++) {
            this.weight[i] = weight[i - 1];
            this.value[i] = value[i - 1];
        }
        this.max_weight = max_weight + 1;
        this.dp = new int[weight.length + 1][max_weight + 1];
    }

    public int getMaxValue() {
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < max_weight; j++) {
                if (weight[i] > j) // 若第i件物品放不下单独处理，防止j - weight[i]<0导致数组越界错
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[weight.length - 1][max_weight - 1];
    }

    public static void main(String[] args) {
        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        int max_weight = 10;
        Bag01 bag = new Bag01(weight, value, max_weight);
        System.out.println(bag.getMaxValue());
    }
}
