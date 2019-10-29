import java.util.Stack;

/**
 * @Author: Wenhang Chen
 * @Description:用一个栈实现另一个栈的排序
 * @Date: Created in 16:07 10/29/2019
 * @Modified by:
 */
public class SortStackByStack {
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        // 依次弹出stack元素，如果弹出的cur小于等于help栈顶元素，就压入
        // 否则把help栈元素逐个倒回stack，直到满足cur小于help.peek()
        // 继续以上操作，最后把help完全倒回stack
        while (!stack.empty()) {
            int cur = stack.pop();
            while (!help.empty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.empty()) {
            stack.push(help.pop());
        }
    }
}
