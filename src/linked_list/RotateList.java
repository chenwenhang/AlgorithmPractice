package linked_list;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * @Date: Created in 21:36 11/25/2019
 * @Modified by:
 */
public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        // 获取ListNode的长度，last最终指向结尾
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            len++;
        }
        // 获取实际移动位数，指针回到头部
        k %= len;
        ListNode p = head;
        // 找到断点的前一个结点
        for (int i = 1; i < len - k; i++) {
            p = p.next;
        }
        // 重接
        last.next = head;
        last = p.next;
        p.next = null;
        return last;
    }
}



















