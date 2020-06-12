package array_and_matrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * <p>
 * 例如，
 * <p>
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * <p>
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * @Date: Created in 9:57 6/12/2020
 * @Modified by:
 */
public class DictionaryOrderNumber {
    public List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.add(Integer.parseInt(list.get(i)));
        }
        return res;
    }
}
















