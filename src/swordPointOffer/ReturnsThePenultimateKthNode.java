package swordPointOffer;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 21:00 5/7/2020
 * @Modified by:
 */
public class ReturnsThePenultimateKthNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        int num = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            num++;
        }
        num -= k;
        p = head;
        while (num != 0) {
            p = p.next;
            num--;
        }
        return p.val;
    }
}
