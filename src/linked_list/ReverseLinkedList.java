package linked_list;

/**
 * @Author: Wenhang Chen
 * @Description:反转一个单链表。 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @Date: Created in 14:45 12/4/2019
 * @Modified by:
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 迭代
    public ListNode reverseListByIteration(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        ListNode nex, pre = null;
        while (p != null) {
            nex = p.next;
            p.next = pre;
            pre = p;
            p = nex;
        }
        return pre;
    }

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        // 每次操作都会更新，所以中间出现null会被覆盖
        head.next.next = head;
        head.next = null;
        return p;
    }
}
