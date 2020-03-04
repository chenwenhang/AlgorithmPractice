package binary_tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * @Date: Created in 8:31 3/4/2020
 * @Modified by:
 */
public class MaximumDepthofNaryTree {
    // 节点定义
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heights = new LinkedList<>();
            for (Node item : root.children) {
                heights.add(maxDepth(item));
            }
            return Collections.max(heights) + 1;
        }
    }

}
