package binary_tree;

import sun.reflect.generics.tree.Tree;

/**
 * @Author: Wenhang Chen
 * @Description: 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * <p>
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * @Date: Created in 11:51 12/20/2019
 * @Modified by:
 */
public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int val = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPath(root);
        return val;
    }

    public int getMaxPath(TreeNode root) {
        if (root == null) return 0;
        int left = getMaxPath(root.left);
        int right = getMaxPath(root.right);
        //   a
        //  / \
        // b   c

        // 一型：bac的情况
        int lmr = root.val + Math.max(0, left) + Math.max(0, right);
        // 二型：ac和a的父节点或ab和a的父节点的情况
        int ret = root.val + Math.max(0, Math.max(left, right));
        val = Math.max(val, Math.max(lmr, ret));
        // 最终返回当前子树的二型最大路径长度
        return ret;
    }
}























