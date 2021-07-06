# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
        if not root:
            return 0
        return self.pathSum(root.left, sum) + self.pathSum(root.right, sum) + self.preorder_traversal(root, sum)

    def preorder_traversal(self, p: TreeNode, sum: int) -> int:
        if not p:
            return 0
        ret = 1 if sum == p.val else 0
        sum -= p.val
        return self.preorder_traversal(p.left, sum) + self.preorder_traversal(p.right, sum) + ret
