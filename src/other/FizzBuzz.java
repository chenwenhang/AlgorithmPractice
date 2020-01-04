package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>
 * 示例：
 * <p>
 * n = 15,
 * <p>
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * @Date: Created in 9:26 1/4/2020
 * @Modified by:
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        String[] arr = new String[n];

        for (int i = 1; i <= n; i++)
            arr[i - 1] = String.valueOf(i);

        for (int i = 3; i <= n; i += 3)
            arr[i - 1] = "Fizz";

        for (int i = 5; i <= n; i += 5)
            arr[i - 1] = "Buzz";

        for (int i = 15; i <= n; i += 15)
            arr[i - 1] = "FizzBuzz";

        return new ArrayList<>(Arrays.asList(arr));
    }
}
















