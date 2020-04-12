package company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 19:02 4/11/2020
 * @Modified by:
 */
public class Sword999 {
    static class Node {
        int x;
        int y;
        int p;
        double dis;

        public Node(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }

        public void cal(int xx, int yy) {
            this.dis = Math.sqrt(Math.pow(xx - x, 2) + Math.pow(yy - y, 2));
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // 每组样例
        while (T-- > 0) {
            // 游戏区域大小
            int M = sc.nextInt();
            // 开始大刀长度
            int L = sc.nextInt();
            // 输入棋盘
//            int[][] a = new int[M][M];
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
//                    a[i][j] = sc.nextInt();
                    int p = sc.nextInt();
                    if (p > 0) {
                        list.add(new Node(i, j, p));
                    }
                }
            }
            // 主角初始位置
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 计算距离
            for (Node node : list) {
                node.cal(x, y);
            }
            // 排序
            list.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Double.compare(o1.dis, o2.dis);
                }
            });
            // 计算
            for (Node node : list) {
//                System.out.println(node.x + " " + node.y + " " + node.dis);
                if (node.dis <= L) {
                    L += node.p;
                } else {
                    break;
                }
            }

            System.out.println(L);
        }
    }
}

















