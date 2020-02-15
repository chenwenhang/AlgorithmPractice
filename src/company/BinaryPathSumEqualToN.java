package company;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。  
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * @Date: Created in 8:16 2/15/2020
 * @Modified by:
 */
public class BinaryPathSumEqualToN {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int total = 0;
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    void helper(TreeNode root, int sum) {
        if (root == null) return;
        int middle = root.val;
        total += middle;
        path.add(middle);
        // 题目说要到叶子结点
        if (total == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        helper(root.left, sum);
        helper(root.right, sum);
        total -= middle;
        // 需要判断是否越界
        if (!path.isEmpty())
            path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return res;
    }
}






















