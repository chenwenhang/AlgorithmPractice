import java.util.*;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个没有重复数字的序列，返回其所有可能的全排列。 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @Date: Created in 11:26 11/23/2019
 * @Modified by:
 */
/*
 * 递归是一种算法结构，回溯是一种算法思想
 * 一个递归就是在函数中调用函数本身来解决问题
 * 回溯就是通过不同的尝试来生成问题的解，有点类似于穷举，但是和穷举不同的是回溯会“剪枝”
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 使用位图，适用于数组 nums 的长度不超过 32 位的情况
        int used = 0;
        // 用栈存储当前数字序列
        Stack<Integer> stack = new Stack<>();

        backtrack(nums, 0, len, used, stack, res);
        return res;
    }

    // curSize 表示当前的路径 path 里面有多少个元素
    private void backtrack(int[] nums, int depth, int len, int used, Stack<Integer> stack, List<List<Integer>> res) {
        // 注意，退出函数的方式有两种
        // 对于叶子结点：发现此时长度为len，则return
        // 对于非叶子结点：执行循环，直到当前层已经遍历一遍所有未标记结点
        if (depth == len) {
            // 此时 stack 已经保存了 nums 中的所有数字，已经成为了一个排列
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            // 如果未标记
            if (((used >> i) & 1) == 0) {// &1是为了只看最后一位，先忽略前面的位
                used ^= (1 << i);
                stack.push(nums[i]);

                backtrack(nums, depth + 1, len, used, stack, res);

                stack.pop();
                used ^= (1 << i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Permutations solution = new Permutations();
        List<List<Integer>> permute = solution.permute(nums);
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(permute.get(i));
        }
    }
}






















