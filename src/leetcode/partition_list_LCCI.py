# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        left = ListNode(0)
        right = ListNode(0)
        left_head = left
        right_head = right
        while head:
            # print(head.val)
            if head.val < x:
                left.next = ListNode(head.val)
                left = left.next
            else:
                right.next = ListNode(head.val)
                right = right.next
            head = head.next
        left.next = right_head.next
        return left_head.next


h = ListNode(1)
p = h
p.next = ListNode(4)
p = p.next
p.next = ListNode(3)
p = p.next
p.next = ListNode(2)
p = p.next
p.next = ListNode(5)
p = p.next
p.next = ListNode(2)
p.next = None

sol = Solution()
t = sol.partition(h, 3)
while t:
    print(t.val)
    t = t.next
