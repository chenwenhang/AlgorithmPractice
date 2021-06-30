# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        root = ListNode()
        p = root
        add = 0
        while l1 and l2:
            l1.val = l1.val + l2.val + add
            add = l1.val // 10
            l1.val %= 10
            p.next = l1
            p = p.next
            l1 = l1.next
            l2 = l2.next

        while l1:
            l1.val += add
            add = l1.val // 10
            l1.val %= 10
            p.next = l1
            p = p.next
            l1 = l1.next

        while l2:
            l2.val += add
            add = l2.val // 10
            l2.val %= 10
            p.next = l2
            p = p.next
            l2 = l2.next

        if add != 0:
            p.next = ListNode(add)

        return root.next
