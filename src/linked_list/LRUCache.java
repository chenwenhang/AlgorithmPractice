package linked_list;


import java.util.Hashtable;

/**
 * @Author: Wenhang Chen
 * @Description:运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2)
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * @Date: Created in 11:11 12/1/2019
 * @Modified by:
 */
public class LRUCache {

    // 寻找位置的哈希表
    private Hashtable<Integer, DLinkedNode> cache =
            new Hashtable<Integer, DLinkedNode>();
    // 当前容量
    private int size;
    // 最大容量
    private int capacity;
    // 定义头尾结点
    private DLinkedNode head, tail;

    // 定义结点
    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }


    // 在头部插入结点，双链表操作
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // 在尾部删除结点，双链表操作
    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // 访问过结点后，要移动到头部，get会引发，put到相同的结点也会引发
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    // 弹出最后一个结点（不是尾结点）
    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    // 初始化
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        // 初始化头尾
        head.next = tail;
        tail.prev = head;
    }

    // get操作
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        // 如果没有，返回-1
        if (node == null) return -1;

        // 移动到头部
        moveToHead(node);

        return node.value;
    }

    // put操作
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            // 添加结点，链表和哈希表中都要加
            cache.put(key, newNode);
            addNode(newNode);

            // 更新容量
            ++size;

            // 如果容量超了，需要弹出最后的结点
            if (size > capacity) {
                // 删除链表结点
                DLinkedNode tail = popTail();
                // 同时删Hashtable中的结点
                cache.remove(tail.key);
                // 更新容量
                --size;
            }
        } else {
            // 如果密钥已存在，移动到头部
            node.value = value;
            moveToHead(node);
        }
    }
}




