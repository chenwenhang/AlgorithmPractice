package company;

import java.util.*;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 19:00 4/15/2020
 * @Modified by:
 */
public class MostVote {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || s.charAt(i) == ',')) {
                System.out.println("error.0001");
                return;
            }
        }
        String[] str = s.split(",");
        int max_num = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String ss : str) {
            if (!(ss.charAt(0) >= 'A' && ss.charAt(0) <= 'Z')) {
                System.out.println("error.0001");
                return;
            }
            for (int i = 1; i < ss.length(); i++) {
                if (!(ss.charAt(i) >= 'a' && ss.charAt(i) <= 'z')) {
                    System.out.println("error.0001");
                    return;
                }
            }
            map.put(ss, map.getOrDefault(ss, 0) + 1);
            max_num = max_num > map.get(ss) ? max_num : map.get(ss);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer) entry.getValue() == max_num) {
                list.add((String) entry.getKey());
            }
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        if (list.size() > 0)
            System.out.println(list.get(0));
        else
            System.out.println("error.0001");
    }
}
