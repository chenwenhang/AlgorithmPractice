package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。  
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * @Date: Created in 9:30 4/4/2020
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

    //    非递归写法
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode t;
        while (q.next != null) {
            t = q.next;
            q.next = p;
            p = q;
            q = t;
        }
        q.next = p;
        head.next = null;
        return q;
    }
}


















