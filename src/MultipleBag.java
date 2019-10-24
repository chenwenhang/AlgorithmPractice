import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:背包问题：一共n种物品，第n种物品有n[i]个
 * @Date: Created in 15:06 10/23/2019
 * @Modified by:
 */
public class MultipleBag {
    int[][] dp;// dp表格
    int max_weight;// 背包容量

    List<Integer> weightList = new ArrayList<>();// 用于存储转化成01背包问题的质量数组
    List<Integer> valueList = new ArrayList<>();// 用于存储转化成01背包问题的价值数组

    public MultipleBag(int[] weight, int[] value, int[] num, int max_weight) {
        this.weightList.add(0);
        this.valueList.add(0);
        for (int i = 0; i < weight.length; i++) {// 转化为01背包
            for (int j = 0; j < num[i]; j++) {
                weightList.add(weight[i]);
                valueList.add(value[i]);
            }
        }
        this.max_weight = max_weight + 1;
        this.dp = new int[weightList.size()][max_weight + 1];// 初始化dp矩阵
    }

    public int getMaxValue() {
        for (int i = 1; i < this.weightList.size(); i++) {// 从1开始是为了让0第一行，因为状态转移方程是建立在上一行基础上的
            for (int j = 1; j < this.max_weight; j++) {
                if (this.weightList.get(i) > j) // 若第i件物品放不下单独处理，防止j - weight[i]<0导致数组越界错
                    this.dp[i][j] = this.dp[i - 1][j];
                else
                    this.dp[i][j] = Math.max(this.dp[i - 1][j], this.dp[i - 1][j - this.weightList.get(i)] + this.valueList.get(i));
            }
        }
        return this.dp[weightList.size() - 1][max_weight - 1];
    }

    public static void main(String[] args) {
        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        int[] num = {2, 2, 3, 2, 2};
        int max_weight = 10;
        MultipleBag multipleBag = new MultipleBag(weight, value, num, max_weight);
        System.out.println(multipleBag.getMaxValue());
    }
}
