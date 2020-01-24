package binary_tree;

import java.util.*;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * @Date: Created in 20:19 1/24/2020
 * @Modified by:
 */
public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        int curCount = 1;
        int nextCount = 0;

        List<Integer> valueList = new ArrayList<>();
        while (!queue.isEmpty()) {
            curCount--;
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                nextCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextCount++;
            }
            valueList.add(node.val);
            if (curCount == 0) {
                // 直接add会报错，因为valueList自始至终指向同一个对象
                // res.add(valueList);

                // 集合对象复制这边有坑
                res.add(new ArrayList(valueList));
                valueList.clear();
                curCount = nextCount;
                nextCount = 0;
            }
        }


        return res;
    }

}
