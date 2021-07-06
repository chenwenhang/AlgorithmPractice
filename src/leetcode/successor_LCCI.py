# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def __init__(self):
        self.has_find = False
        self.cur_node = None

    def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> TreeNode:
        self.inorder_traversal(root, p)
        return self.cur_node

    def inorder_traversal(self, node: TreeNode, p: TreeNode) -> None:
        if node.left:
            self.inorder_traversal(node.left, p)

        if not self.has_find and node.val == p.val:
            self.has_find = True
        elif self.has_find and not self.cur_node:
            self.cur_node = node
            return
        elif self.cur_node:
            return

        if node.right:
            self.inorder_traversal(node.right, p)
