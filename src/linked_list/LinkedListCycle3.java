package linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点
 * @Date: Created in 14:33 11/30/2019
 * @Modified by:
 */
public class LinkedListCycle3 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        // 先让快慢指针一起跑，直到相遇。此时已跑过的路程：
        // 慢指针：F + a        其中 F 为环外长度，a 为慢指针在环中已经走过的长度，即 环起点 -> 当前点
        // 快指针：2(F + a)     由于快指针速度是慢指针的两倍，所以为2(F + a)
        // 下面采用另一种方式表示快指针走的路径。环外走了 F，环内走了a + b，b 表示快指针在环中比满指针
        // 多走的，最终追上慢指针的路径长度
        // 那么有：2(F + a) = F + a + b
        // 解之：F = b
        // 下面要知道环起始点，只需从 当前点 再走 b 的长度，就可以回到环起始点
        // 那么在放个指针从最初的起点开始走 F ，同时让慢指针从当前点开始走即可，最终重合即为环起始点
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }
        // 如果没有重合，代表没有环
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // 获得相遇结点
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        // 再从当前结点走 b 的长度（即F的长度），相遇即为环入口
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
}