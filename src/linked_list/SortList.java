package linked_list;

/**
 * @Author: Wenhang Chen
 * @Description:在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @Date: Created in 8:34 12/15/2019
 * @Modified by:
 */
public class SortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 递归写法
    // 经典写法，但空间复杂度 O(logn)，不符合题意
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        // 用快慢指针找到中间结点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 由中部切断
        ListNode tmp = slow.next;
        slow.next = null;
        // 递归，不断二分
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        // merge
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left == null ? right : left;
        return res.next;
    }

    // 自下而上归并排序，空间复杂度O(1)
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode h = head;
        int length = 0, intv = 1;
        while (h != null) {
            h = h.next;
            length += 1;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        while (intv < length) {
            ListNode pre = res;
            h = res.next;
            while (h != null) {
                ListNode h1 = h;
                int i = intv;
                while (i != 0 && h != null) {
                    h = h.next;
                    i -= 1;
                }
                if (i != 0) {
                    break;
                }
                ListNode h2 = h;
                i = intv;
                while (i != 0 && h != null) {
                    h = h.next;
                    i -= 1;
                }
                int c1 = intv, c2 = intv - i;
                while (c1 != 0 && c2 != 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        c1 -= 1;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        c2 -= 1;
                    }
                    pre = pre.next;
                }
                pre.next = c1 != 0 ? h1 : h2;
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1 -= 1;
                    c2 -= 1;
                }
                pre.next = h;
            }
            intv *= 2;
        }
        return res.next;
    }

    /**
     * 归并两个已经排好序的单链表，是我们非常熟悉的操作了，可以递归完成，也可以穿针引线，这里我们递归完成
     *
     * @param l1 顺序存放的单链表1
     * @param l2 顺序存放的单链表2
     * @return 合并以后的单链表
     */
//    private ListNode mergeOfTwoSortedListNode(ListNode l1, ListNode l2) {
//        ListNode h = new ListNode(0);
//        ListNode res = h;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                h.next = l1;
//                l1 = l1.next;
//            } else {
//                h.next = l2;
//                l2 = l2.next;
//            }
//            h = h.next;
//        }
//        h.next = l1 != null ? l1 : l2;
//        return res.next;
//    }
}



















