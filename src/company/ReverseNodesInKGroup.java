package company;

/**
 * @Author: Wenhang Chen
 * @Description:给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @Date: Created in 9:04 2/6/2020
 * @Modified by:
 */
public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // 用新结点作为头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 存储链表的前驱
        ListNode pre = dummy;
        // 存储链表的末尾
        ListNode end = dummy;
        // 当末尾还有结点时
        while (end.next != null) {
            // 移动到链表第k个位置
            for (int i = 0; i < k && end != null; i++) end = end.next;
            // 如果end此时为null，说明结点少于k个，不做变化，直接跳出
            if (end == null) break;
            // start存储链表头（反转后为链表尾）
            ListNode start = pre.next;
            // next存储链表的后继
            ListNode next = end.next;
            // 断链，并从start处开始反转
            end.next = null;
            // 前驱的后继为当前链表的头（连接当前段和前一段）
            pre.next = reverse(start);
            // 此时start为链表的末尾，连接当前链表和下一段
            start.next = next;
            // 更新前驱为start，因为此时start为反转后的尾结点
            pre = start;
            // 更新end
            end = pre;
        }
        // 返回链表头
        return dummy.next;
    }

    // 反转链表，返回反转后的头结点
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}

















