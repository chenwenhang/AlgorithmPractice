/**
 * @Author: Wenhang Chen
 * @Description:给定直线上2n个点的序列P[1, 2,… ,2n]，每个点 P[i]要么是白点要么是黑点，其中共有n个白点和 n个黑点，相邻两个点之间距离均为1，请设计一个算法将每个白点与一黑点相连，使得连线的总长度最小。例如，图中有4个白点和4个黑点，以图中方式相连，连线总长度为1+1+1+5=8。
 * @Date: Created in 19:53 11/18/2019
 * @Modified by:
 */
public class MinBlackWhiteLine {
    public static int getMinBlackWhiteLine(boolean[] point) {
        int line = 0;// 连线总长度
        int pace = 1;// 跨度
        int countConnect = 0;// 已连接的点个数
        boolean[] isConnect = new boolean[point.length];// 当前点是否连接过
        // 循环到所有点都已经连接
        for (; countConnect < point.length; pace++) {
            for (int i = 0; i < point.length; i++) {
                // 越界，进行下一轮
                if (i + pace >= point.length)
                    break;
                // 如果当前点和目标点都没有连接过，并且异色
                if (!isConnect[i] && !isConnect[i + pace] && point[i] != point[i + pace]) {
                    // 更新总长度
                    line += pace;
                    // 更新已连接点数
                    countConnect += 2;
                    // 当前点和目标点设置为已连接
                    isConnect[i] = true;
                    isConnect[i + pace] = true;
                }
            }
        }
        return line;
    }

    public static void main(String[] args) {
        System.out.println(getMinBlackWhiteLine(new boolean[]{true, true, false, true, false, false, false, true}));
    }
}
