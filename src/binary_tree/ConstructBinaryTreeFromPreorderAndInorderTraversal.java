package binary_tree;

import java.util.HashMap;

/**
 * @Author: Wenhang Chen
 * @Description:根据一棵树的前序遍历与中序遍历构造二叉树。 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * @Date: Created in 8:42 1/27/2020
 * @Modified by:
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // start from first preorder element
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果该子树没有元素，即为空
        if (in_left == in_right) return null;

        // 获取该子树的根节点
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        // 获取根节点在中序遍历中的位置
        int index = idx_map.get(root_val);

        // 更新先序遍历的索引，开始递归
        pre_idx++;
        root.left = helper(in_left, index);
        root.right = helper(index + 1, in_right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        // 建立反向索引，题目已假设无重复值
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length);
    }


}
















