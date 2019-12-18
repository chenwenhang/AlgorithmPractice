package binary_tree;

import sun.reflect.generics.tree.Tree;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 8:57 12/18/2019
 * @Modified by:
 */
public class KthSmallestElementInABST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int num = 0;
    TreeNode target;

//    static class StopMsgException extends RuntimeException {
//    }

    public void getSmallest(TreeNode curNode, int k) {
        if (curNode == null) return;
        getSmallest(curNode.left, k);
        num++;
        if (num == k) {
            target = curNode;
//            跳出所有递归
//            throw new StopMsgException();
        }
        getSmallest(curNode.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        getSmallest(root, k);
        return target.val;
    }
}
