package swordPointOffer;

import java.util.Stack;

/**
 * @Author: Wenhang Chen
 * @Description:用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * @Date: Created in 8:37 3/25/2020
 * @Modified by:
 */
public class CQueue {
    Stack<Integer> stIn;
    Stack<Integer> stOut;

    public CQueue() {
        stIn = new Stack<>();
        stOut = new Stack<>();
    }

    public void appendTail(int value) {
        stIn.push(value);
    }

    public int deleteHead() {
        if (stOut.isEmpty()) {
            if (stIn.isEmpty()) return -1;
            while (!stIn.isEmpty()) {
                stOut.push(stIn.pop());
            }
        }
        return stOut.pop();
    }
}
