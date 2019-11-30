package linked_list;

import java.util.HashSet;
import java.util.List;
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
public class LinkedListCycle2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) return node;
            visited.add(node);
            node = node.next;
        }
        return null;
    }
}
