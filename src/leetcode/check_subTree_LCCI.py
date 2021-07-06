# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def checkSubTree(self, t1: TreeNode, t2: TreeNode) -> bool:
        return self.preorder_traversal(t1, t2)

    def preorder_traversal(self, p: TreeNode, t2: TreeNode) -> bool:
        if not p:
            return False
        elif self.preorder(p, t2):
            return True
        return self.preorder_traversal(p.left, t2) or self.preorder_traversal(p.right, t2)

    def preorder(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        elif not q or not p:
            return False
        elif p.val != q.val:
            return False
        return self.preorder(p.left, q.left) and self.preorder(p.right, q.right)
