package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:背包问题：刚好装满
 * @Date: Created in 16:05 10/23/2019
 * @Modified by:
 */
public class ProperBag {
    int[] weight;// 物品的质量数组
    int[] value;// 物品的价值数组
    int[][] dp;// dp表格
    int max_weight;// 背包容量

    public ProperBag(int[] weight, int[] value, int max_weight) {
        // 把dp[i][0]都看作是装满的，初始化为0，其他的都是-INX_MAX
        // 按照01背包不一定完全装满的情况运行
        // dp[n][m]为负数，代表没有解
        this.weight = new int[weight.length + 1];
        this.value = new int[value.length + 1];
        for (int i = 1; i <= weight.length; i++) {
            this.weight[i] = weight[i - 1];
            this.value[i] = value[i - 1];
        }
        this.max_weight = max_weight + 1;
        this.dp = new int[weight.length + 1][max_weight + 1];
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
            for (int j = 1; j < max_weight; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public int getMaxValue() {// 若刚好装满，则前一个状态必定也刚好装满
        int max_value = Integer.MIN_VALUE;
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < max_weight; j++) {
                if (weight[i] > j) // 若第i件物品放不下单独处理，防止j - weight[i]<0导致数组越界错
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                max_value = max_value > dp[i][j] ? max_value : dp[i][j];
            }
        }
//        for (int i = 0; i < weight.length; i++) {
//            for (int j = 0; j < max_weight; j++) {
//                System.out.print(dp[i][j] + "  ");
//            }
//            System.out.println();
//        }
        return dp[weight.length - 1][max_weight - 1];
    }

    public static void main(String[] args) {
        int[] weight = {1, 2, 3, 2};
        int[] value = {4, 6, 12, 7};
        int max_weight = 6;
        ProperBag properBag = new ProperBag(weight, value, max_weight);
        int res = properBag.getMaxValue();
        if (res > 0)
            System.out.println("Max value:" + res);
        else
            System.out.println("Can not fill the bag");

    }
}
