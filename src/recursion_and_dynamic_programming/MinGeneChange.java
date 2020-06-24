package recursion_and_dynamic_programming;

import java.util.HashSet;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 21:11 6/24/2020
 * @Modified by:
 */
public class MinGeneChange {
    int minStepCount = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<String>(), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }

    private void dfs(HashSet<String> step, int stepCount,
                     String current, String end, String[] bank) {
        if (current.equals(end))
            minStepCount = Math.min(stepCount, minStepCount);
        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++)
                if (current.charAt(i) != str.charAt(i))
                    if (++diff > 1) break;
            if (diff == 1 && !step.contains(str)) {
                step.add(str);
                dfs(step, stepCount + 1, str, end, bank);
                step.remove(str);
            }
        }
    }
}
