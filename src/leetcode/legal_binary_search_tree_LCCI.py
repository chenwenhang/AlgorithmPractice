# Definition for a binary tree node.
from collections import deque
from typing import Tuple


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 二叉搜索树是一种节点值之间具有一定数量级次序的二叉树，对于树中每个节点：
    # 若其左子树存在，则其左子树中每个节点的值都不大于该节点值；
    # 若其右子树存在，则其右子树中每个节点的值都不小于该节点值。
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return True
        _, _, flag = self.recursive(root)
        return flag

    def recursive(self, node: TreeNode) -> Tuple:
        # max_val: 当前树的最大值
        # min_val: 当前树的最小值
        # flag: 标记状态
        if not node.left and not node.right:
            return node.val, node.val, True
        elif not node.right:
            max_val, min_val, f = self.recursive(node.left)
            flag = f and max_val < node.val
            print("node:{}, max:{}, min:{}, flag:{}".format(node.val, node.val, min_val, flag))
            return node.val, min_val, flag
        elif not node.left:
            max_val, min_val, f = self.recursive(node.right)
            flag = f and min_val > node.val
            print("node:{}, max:{}, min:{}, flag:{}".format(node.val, max_val, node.val, flag))
            return max_val, node.val, flag
        else:
            max_val_1, min_val_1, f1 = self.recursive(node.left)
            max_val_2, min_val_2, f2 = self.recursive(node.right)
            flag = f1 and f2 and max_val_1 < node.val < min_val_2
            print("node:{}, max:{}, min:{}, flag:{}".format(node.val, min_val_1, max_val_2, flag))
            return max_val_2, min_val_1, flag
