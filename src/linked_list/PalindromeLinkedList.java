package linked_list;

/**
 * @Author: Wenhang Chen
 * @Description:请判断一个链表是否为回文链表。 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * @Date: Created in 10:24 1/11/2020
 * @Modified by:
 */
public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null) {
            // fast到最后时，slow为中间
            // 在遍历过程中翻转前半部分链表
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }

        if (fast != null) {
            // 如果为奇数个，则slow要往后一次
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}














