package array_and_matrix;

/**
 * @Author: Wenhang Chen
 * @Description:冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * <p>
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 * <p>
 * 说明:
 * <p>
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 示例 1:
 * <p>
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * @Date: Created in 8:28 6/4/2020
 * @Modified by:
 */
public class Heater {
    public int findNearest(int n, int[] heaters) {//找到离n最近的供暖器
        int ans = 1500000000;
        for (int i = 0; i < heaters.length; i++) {
            ans = Math.min(ans, Math.abs(heaters[i] - n));
        }
        return ans;
    }

    public int findRadius(int[] houses, int[] heaters) {
        int rad = -1;
        for (int i = 0; i < houses.length; i++) {
            //供暖器取离得最近的那个的半径
            //最小加热半径要取所有半径中最大的
            rad = Math.max(rad, findNearest(houses[i], heaters));
        }
        return rad;
    }
}













