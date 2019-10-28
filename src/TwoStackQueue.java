import java.util.Stack;

/**
 * @Author: Wenhang Chen
 * @Description:由两个栈实现的队列
 * @Date: Created in 9:55 10/28/2019
 * @Modified by:
 */
public class TwoStackQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    // push栈向pop栈倒入数据
    private void pushToPop() {
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());
        twoStackQueue.add(3);
        System.out.println(twoStackQueue.poll());
    }
}
