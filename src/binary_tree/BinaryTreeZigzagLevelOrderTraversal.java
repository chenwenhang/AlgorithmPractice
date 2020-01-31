package binary_tree;

import java.util.*;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * @Date: Created in 10:52 1/31/2020
 * @Modified by:
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 为奇数层和偶数层采用不同的栈
        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();
        if (root != null) oddStack.add(root);
        int curCount = 1;
        int nextCount = 0;
        boolean order = true;

        List<Integer> valueList = new ArrayList<>();
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            TreeNode node;
            curCount--;
            if (order) {
                node = oddStack.pop();
                if (node.left != null) {
                    evenStack.push(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    evenStack.push(node.right);
                    nextCount++;
                }
            } else {
                node = evenStack.pop();
                if (node.right != null) {
                    oddStack.push(node.right);
                    nextCount++;
                }
                if (node.left != null) {
                    oddStack.push(node.left);
                    nextCount++;
                }
            }
            valueList.add(node.val);
//            System.out.println(node.val);

            if (curCount == 0) {
                order = !order;
                res.add(new ArrayList(valueList));
                valueList.clear();
                curCount = nextCount;
                nextCount = 0;
            }
        }


        return res;
    }
}


















