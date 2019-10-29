import java.util.Stack;

/**
 * @Author: Wenhang Chen
 * @Description:实现一个特殊的栈，这个栈在基本功能基础上，在实现返回最小元素的操作
 * @Date: Created in 16:58 10/19/2019
 * @Modified by:
 */
public class MyStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public int getmin() {
        if (this.stackMin.empty()) {
            throw new RuntimeException("This stack is empty");
        }
        return this.stackMin.peek();
    }

    public void push(int newNum) {
//        stackMin的顶端一直存储最小元素， 如果当前
//       元素小于最小元素，就把当前元素压到stackMin
//       栈中，否则把stackMin栈顶元素再压进去一次
//       这样弹出的时候两个栈都弹出
        if (this.stackMin.empty()) {
            this.stackData.push(newNum);
        } else if (newNum < this.getmin()) {
            this.stackMin.push(newNum);
        } else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.empty()) {
            throw new RuntimeException("This stack is empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }
}
