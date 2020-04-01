package SwordPointOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 8:51 4/1/2020
 * @Modified by:
 */
public class ArrangeArrayIntoSmallestNumber {
//    若拼接 s1 + s2 > s2 + s1，那么显然应该把 s2 在拼接时放在前面
    public String minNumber(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }

}
