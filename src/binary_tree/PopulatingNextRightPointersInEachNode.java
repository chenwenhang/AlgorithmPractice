package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * @Date: Created in 11:27 1/30/2020
 * @Modified by:
 */
public class PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        int curCount = 1;
        int nextCount = 0;

        while (!queue.isEmpty()) {
            curCount--;
            Node node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                nextCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextCount++;
            }
            if (curCount == 0) {
                curCount = nextCount;
                nextCount = 0;
                node.next = null;
            } else {
                node.next = queue.peek();
            }
        }
        return root;
    }

    // 递归解法，先劈成两半处理之间的，再逐一对两子树进行处理
    public Node connect2(Node root) {
        if (root == null) return root;
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect2(root.left);
        connect2(root.right);
        return root;
    }
}