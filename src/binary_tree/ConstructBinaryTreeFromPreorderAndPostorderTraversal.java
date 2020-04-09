package binary_tree;

/**
 * @Author: Wenhang Chen
 * @Description:返回与给定的前序和后序遍历匹配的任何二叉树。  pre 和 post 遍历中的值是不同的正整数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= pre.length == post.length <= 30
 * pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 * @Date: Created in 8:49 4/9/2020
 * @Modified by:
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int length = post.length - 1;
        return helper(pre, post, 0, length, 0, length);
    }

    TreeNode helper(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        // 如果只有一个节点，返回该节点
        if (preStart == preEnd) return new TreeNode(pre[preStart]);
        // 如果开始索引大于结束索引，return
        if (preStart > preEnd) return null;

        // 新建根节点
        TreeNode root = new TreeNode(pre[preStart]);
        // 获取先序遍历下一个节点的值
        int val = pre[preStart + 1];

        for (int i = postStart; i <= postEnd; i++) {
            if (post[i] == val) {
                // 获取区间长度
                int length = i - postStart;
                // 下面分两段递归
                root.left = helper(pre, post, preStart + 1, preStart + length + 1, postStart, i);
                root.right = helper(pre, post, preStart + length + 2, preEnd, i + 1, postEnd - 1);
                return root;
            }
        }
        return null;
    }
}
























