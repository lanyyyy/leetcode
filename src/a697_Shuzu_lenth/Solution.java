package a697_Shuzu_lenth;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}) == 2);
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}) == 6);
        System.out.println(solution.findShortestSubArray(new int[]{1}) == 1);
        System.out.println(solution.findShortestSubArray(new int[]{1, 2}) == 1);
        System.out.println(solution.findShortestSubArray(new int[]{1, 1, 2, 2}) == 2);
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], null) == null) {
                map.put(nums[i], Arrays.asList(i, i, 1));
            } else {
                List<Integer> integers = map.get(nums[i]);
                integers.set(1, i);
                integers.set(2, integers.get(2) + 1);
                map.put(nums[i], integers);
            }
        }

        List<Integer> result = Arrays.asList(0, 0, 0);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().get(2) > result.get(2)) {
                result = entry.getValue();
            } else if (entry.getValue().get(2).equals(result.get(2))) {
                if (entry.getValue().get(1) - entry.getValue().get(0) < result.get(1) - result.get(0)) {
                    result = entry.getValue();
                }
            }
        }

        return result.get(1) - result.get(0) + 1;

    }
}
