package stack_and_queue;

import java.util.LinkedList;

/**
 * @Author: Wenhang Chen
 * @Description:生成窗口最大值数组，返回数组res记录每个窗口的最大值
 * @Date: Created in 20:02 10/30/2019
 * @Modified by:
 */
public class MaxWindow {
    // 用qmax队列存储窗口最大值的下标，队首为最大值下标，
    // 如果qmax队尾的值比当前值小，则弹出队尾元素，重新
    // 开始压入下标操作。如果队尾元素大于当前值，则继续压入
    // 当前值的下标。
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            // 如果脱离窗口，则弹出。
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            // 即使小也压入是因为当前面的元素离开窗口后，后来的
            // 元素可能成为最大值。
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
