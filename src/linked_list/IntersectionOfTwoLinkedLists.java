package linked_list;

/**
 * @Author: Wenhang Chen
 * @Description:编写一个程序，找到两个单链表相交的起始节点。 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * @Date: Created in 9:59 12/2/2019
 * @Modified by:
 */
public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA, p2 = headB;
        int m = 1, n = 1;
        while (p1.next != null) {
            p1 = p1.next;
            m++;
        }
        while (p2.next != null) {
            p2 = p2.next;
            n++;
        }
        if (m < n) {
            p1 = headB;
            p2 = headA;
        } else {
            p1 = headA;
            p2 = headB;
        }
        m = Math.abs(m - n);
        while (m-- > 0) {
            p1 = p1.next;
        }
        while (p1 != null) {
            if (p1 == p2) break;
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}










