# Definition for a binary tree node.
from typing import Tuple


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        _, _, ancestor = self.postorder_traversal(root, p, q)
        return ancestor

    def postorder_traversal(self, node: TreeNode, p: TreeNode, q: TreeNode) -> Tuple:
        ancestor_1, ancestor_2, ancestor = None, None, None
        find_p_1, find_p_2, find_q_1, find_q_2 = False, False, False, False

        if not node.left and not node.right:
            return node.val == p.val, node.val == q.val, None

        if node.left:
            find_p_1, find_q_1, ancestor_1 = self.postorder_traversal(node.left, p, q)
        if node.right:
            find_p_2, find_q_2, ancestor_2 = self.postorder_traversal(node.right, p, q)

        # print("{},{},{},{},{},{},{}".format(find_p_1, find_q_1, ancestor_1, find_p_2, find_q_2, ancestor_2, node.val))

        if ancestor_1 or ancestor_2:
            return True, True, ancestor_1 or ancestor_2
        if (find_p_1 or find_p_2) and (find_q_1 or find_q_2) \
                or (find_p_1 or find_p_2) and (node.val == q.val) \
                or (find_q_1 or find_q_2) and (node.val == p.val):
            ancestor = node
        return (find_p_1 or find_p_2 or node.val == p.val), \
               (find_q_1 or find_q_2 or node.val == q.val), \
               ancestor
