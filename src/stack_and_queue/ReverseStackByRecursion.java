package stack_and_queue;

import java.util.Stack;

/**
 * @Author: Wenhang Chen
 * @Description:仅用递归函数和栈操作逆序一个栈
 * @Date: Created in 12:11 10/29/2019
 * @Modified by:
 */
//思路：从下到上取出栈中元素，作为变量存储在递归函数中，同时在栈中
//删除该元素。回溯的时候从最底层把变量压入栈中。
public class ReverseStackByRecursion {
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.empty()) {
            return result;
        } else {
            // 一直到取到的是最后一个元素
            int last = getAndRemoveLastElement(stack);
            // 取出后回溯，把上面的元素再压回去
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        // 取出栈中最后一个元素，存在变量i里
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        // 回溯的时候，从最里面一层，即栈最上面的元素，依次压回栈中
        stack.push(i);
    }

}
