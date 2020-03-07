package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * @Date: Created in 14:21 3/5/2020
 * @Modified by:
 */
public class BinaryTreeLevelOrderTraversalII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.addLast(null);
        LinkedList<Integer> tempList = null;
        while(!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if(node == null){
                if(tempList != null){
                    result.addFirst(tempList);
                    tempList = null;
                    queue.addLast(null);
                    continue;
                }
            } else {
                if(tempList == null){
                    tempList = new LinkedList<>();
                }
                tempList.addLast(node.val);
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
            }

        }
        return result;
    }
}






















