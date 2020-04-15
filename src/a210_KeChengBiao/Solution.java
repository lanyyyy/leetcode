package a210_KeChengBiao;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findOrder(1, new int[0][0])).equals("[0]"));
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{1, 0}})).equals("[0, 1]"));
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})).equals("[0, 1, 2, 3]"));
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{1, 0}, {0, 1}})).equals("[]"));
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{1, 0}, {0, 1}})).equals("[]"));
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {0, 3}})).equals("[]"));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        int[] inDegrees = initDegree(numCourses, prerequisites);

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        Map<Integer, List<Integer>> map = transfer(prerequisites);

        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer integer = queue.poll();
            result.add(integer);
            if (map.getOrDefault(integer, null) != null) {
                for (Integer val : map.get(integer)) {
                    inDegrees[val] -= 1;
                    if (inDegrees[val] == 0) {
                        queue.add(val);
                    }
                }
            }
        }
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] != 0) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;

    }

    private Map<Integer, List<Integer>> transfer(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.getOrDefault(prerequisites[i][1], null) == null) {
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            if (!map.get(prerequisites[i][1]).contains(prerequisites[i][0])) {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
        }
        return map;
    }

    private int[] initDegree(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            degrees[prerequisites[i][0]] += 1;
        }
        return degrees;
    }

}
