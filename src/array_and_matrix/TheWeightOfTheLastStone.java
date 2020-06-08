package array_and_matrix;

import java.util.PriorityQueue;

/**
 * @Author: Wenhang Chen
 * @Description:有一堆石头，每块石头的重量都是正整数。 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * @Date: Created in 13:47 6/8/2020
 * @Modified by:
 */
public class TheWeightOfTheLastStone {
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (o1, o2) -> -o1 + o2);
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2) {
            Integer head1 = maxHeap.poll();
            Integer head2 = maxHeap.poll();

            maxHeap.offer(head1 - head2);
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {
        TheWeightOfTheLastStone theWeightOfTheLastStone = new TheWeightOfTheLastStone();
        // int[] stones = {2, 7, 4, 1, 8, 1};
        int[] stones = {1, 3};
        int res = theWeightOfTheLastStone.lastStoneWeight(stones);
        System.out.println(res);
    }
}













