package b1202_swap_element_in_str;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestStringWithSwaps("dcab", Arrays.asList(
                Arrays.asList(0,3),
                Arrays.asList(1,2),
                Arrays.asList(0,2)
        )));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        return doMyself(s, pairs);

    }

    /**
     * 贪心：每次判断一下，将大的排到后面
     */
    private String doMyself(String s, List<List<Integer>> pairs) {
        char[] chars = s.toCharArray();
        boolean isOver = false;
        while (!isOver) {
            isOver = true;
            for (int i = 0; i < pairs.size(); i++) {
                if (chars[pairs.get(i).get(0)] > chars[pairs.get(i).get(1)]
                        && pairs.get(i).get(0) < pairs.get(i).get(1)) {
                    char a = chars[pairs.get(i).get(0)];
                    chars[pairs.get(i).get(0)] = chars[pairs.get(i).get(1)];
                    chars[pairs.get(i).get(1)] = a;
                    isOver = false;
                }
            }
        }
        return new String(chars);
    }


}
