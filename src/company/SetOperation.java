package company;

import java.util.*;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 19:31 4/11/2020
 * @Modified by:
 */
public class SetOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // 每组样例
        while (T-- > 0) {
            // 正整数个数
            int N = sc.nextInt();
            List<Set<Integer>> list = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                list.add(set);
            }
            // 操作数
            int M = sc.nextInt();
            // 具体操作
            for (int i = 0; i < M; i++) {
                // 操作类型
                int op = sc.nextInt();
                int a, b;
                // 操作数
                if (op == 1) {
                    a = sc.nextInt();
                    b = sc.nextInt();
                    int p1 = 0, p2 = 0;
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k).contains(a)) {
                            p1 = k;
                        }
                        if (list.get(k).contains(b)) {
                            p2 = k;
                        }
                    }
                    if (p1 != p2) {
                        for (Integer m : list.get(p2)) {
                            list.get(p1).add(m);
                        }
                        list.remove(p2);
                    }
                } else if (op == 2) {
                    a = sc.nextInt();
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k).contains(a) && list.get(k).size() > 1) {
                            list.get(k).remove(a);
                            Set<Integer> s = new HashSet<>();
                            s.add(a);
                            list.add(s);
                            break;
                        }
                    }
                } else {
                    a = sc.nextInt();
                    for (Set<Integer> integers : list) {
                        if (integers.contains(a)) {
                            System.out.println(integers.size());
                            break;
                        }
                    }
                }

            }
        }

    }
}
