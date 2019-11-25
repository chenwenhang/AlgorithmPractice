package recursion_and_dynamic_programming;

/**
 * @Author: Wenhang Chen
 * @Description: 增强汉诺塔（递归解法）：1. 左右移动时必须经过中间，2. 打印最优路径和最优总步数
 * @Date: Created in 19:38 10/31/2019
 * @Modified by:
 */
public class EnhancedHanNoi {
    // 核心：整体思想，把上面N-1个看成一个整体
    // 不要过于拘泥于细节，上面N-1个看成整体之后，操作的时候
    // 直接交给递归函数去做即可
    public static int hanoiProblem(int num) {
        if (num < 1) {
            return 0;
        }
        return process(num, "left", "right");
    }

    public static int process(int num, String from, String to) {
        // 递归跳出条件，如果只有一个圆盘需要移动
        if (num == 1) {
            if (from.equals("mid") || to.equals("mid")) {
                System.out.println(from + " -> " + to + " : 1");
                return 1;
            } else {
                System.out.println(from + " -> " + "mid" + " : 1");
                System.out.println("mid" + " -> " + to + " : 1");
                return 2;
            }
        }
        // 如果移动到中间去或者从中间移出
        if (from.equals("mid") || to.equals("mid")) {
            String another = (from.equals("left") || to.equals("left")) ? "right" : "left";
            /* 把上面N-1个看成一个整体，两个例子：
               左→中
               1. 先把上面N-1个移动到右边；
               2. 然后把最下面的一个移动到中间；
               3. 然后再把右边的N-1个移动到中间；
               中→左
               1. 先把上面N-1个移动到右边；
               2. 然后把最下面的一个移动到左边；
               3. 然后再把右边的N-1个移动到左边；
             */
            int part1 = process(num - 1, from, another);
            int part2 = 1;
            System.out.println(from + " -> " + to + " : " + num);
            int part3 = process(num - 1, another, to);
            return part1 + part2 + part3;
        } else {
            // 如果由左边移动到右边或者由右边移动到左边
            /* 举例：
               左→右
               1. 先把上面N-1个移动到右边；
               2. 再把最下面一个移动到中间；
               3. 接着把右边N-1个移动到左边；
               4. 然后把中间的一个移动到右边；
               5. 最后把左边的N-1个移动到右边；
             */
            int part1 = process(num - 1, from, to);
            int part2 = 1;
            System.out.println(from + " -> " + "mid" + " : " + num);
            int part3 = process(num - 1, to, from);
            int part4 = 1;
            System.out.println("mid" + " -> " + to + " : " + num);
            int part5 = process(num - 1, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public static void main(String[] args) {
        System.out.println(hanoiProblem(2));
    }
}
