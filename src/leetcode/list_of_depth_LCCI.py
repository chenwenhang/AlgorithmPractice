# Definition for a binary tree node.
from collections import deque
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def listOfDepth(self, tree: TreeNode) -> List[ListNode]:
        res = []
        pre_depth = 0
        cur_head = ListNode(0)
        p = cur_head
        q = deque([(tree, 0)])
        while q:
            item = q.popleft()
            node = item[0]
            depth = item[1]
            if pre_depth == depth:
                p.next = ListNode(node.val)
                p = p.next
            else:
                res.append(cur_head.next)
                cur_head = ListNode(0)
                p = cur_head
                p.next = ListNode(node.val)
                p = p.next
                pre_depth = depth
            if node.left:
                q.append((node.left, depth + 1))
            if node.right:
                q.append((node.right, depth + 1))
        # 记得把最后一链表加上
        res.append(cur_head.next)
        return res
