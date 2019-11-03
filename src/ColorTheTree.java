/**
 * @Author: Wenhang Chen
 * @Description:对一棵树进行着色，每个结点可着黑色或白色，相邻结点不能着相同黑色，但可着相同白色。令树的根为r，请设计一种算法对树中尽量多的节点着黑色
 * @Date: Created in 15:57 11/3/2019
 * @Modified by:
 */
class TreeNode {
    int father; // 父节点
    int[] child; // 子节点数组
    int childNum = 0; // 子节点个数
}

/*
 * 记：black[i]为当前结点着黑色的整棵树的最多黑结点数，white[i]为当前结点着白色的整棵树的最多黑结点数
 * 状态转移方程：
 * opt(r) = max(opt(r,0), opt(r,1))
 * opt(r,0) = sum(max(opt(ci,0), opt(ci,1)))
 * opt(r,1) = sum(max(opt(ci,0)) + 1
 * 1表示黑色，0表示白色
 */
public class ColorTheTree {
    static int startColor(int n, TreeNode[] tree) {
        // 初始化子结点数组
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (tree[j].father == i)
                    tree[i].child[tree[i].childNum++] = j;
            }
        }
        int[] black = new int[n];// 当前节点着黑色的最大值
        int[] white = new int[n];// 当前节点着白色的最大值
        int i;
        // 初始化叶子结点着色数组
        for (i = n - 1; tree[i].childNum == 0; i--) {
            black[i] = 1;
            white[i] = 0;
        }
        // 开始dp，从叶子结点向上计算
        for (; i >= 0; i--) {
            // 当前结点为白色
            for (int j = 0; j < tree[i].childNum; j++) {
                white[i] += Math.max(black[tree[i].child[j]], white[tree[i].child[j]]);
            }
            // 当前结点为黑色
            black[i] = 1;
            for (int j = 0; j < tree[i].childNum; j++) {
                black[i] += white[tree[i].child[j]];
            }
        }
        return Math.max(black[0], white[0]);
    }
}
