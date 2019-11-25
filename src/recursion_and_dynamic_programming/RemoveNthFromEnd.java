package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @Date: Created in 14:07 11/18/2019
 * @Modified by:
 */
public class RemoveNthFromEnd {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    int k = 1;

    public ListNode removeNode(ListNode pre, ListNode cur, int n) {
        // 先递归到最底层
        if (cur.next != null) {
            removeNode(cur, cur.next, n);
        }
        // 再回来，头结点需要单独考虑
        if (k == n) {
            if (pre != null) {
                pre.next = cur.next;
                k++;
                return pre;
            } else {
                return cur.next;
            }
        }
        k++;
        return cur;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNode(null, head, n);
    }
}















