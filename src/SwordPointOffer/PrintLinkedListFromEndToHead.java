package SwordPointOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 10:46 3/24/2020
 * @Modified by:
 */
public class PrintLinkedListFromEndToHead {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public int[] reversePrint(ListNode head) {
//        if (head == null) return null;
        List<Integer> res = new ArrayList<>();
        help(res, head);
        int[] list = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            list[i] = res.get(i);
        }
        return list;
    }

    public void help(List<Integer> res, ListNode head) {
        if (head == null) return;
        if (head.next != null) help(res, head.next);
        res.add(head.val);
    }


}












