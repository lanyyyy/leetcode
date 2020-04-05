package a056_merge_qujian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> result = new ArrayList<>();

        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // 合并i和i+1
            if (curr[1] < intervals[i][0]) {
                result.add(new int[]{curr[0], curr[1]});
                curr = intervals[i];
            } else {
                curr[0] = Math.min(curr[0], intervals[i][0]);
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
        }
        result.add(curr);

        int[][] resultShuzu = new int[result.size()][];
        for (int i = 0; i < resultShuzu.length; i++) {
            resultShuzu[i] = result.get(i);
        }
        return resultShuzu;
    }

    public static void main(String[] args) {
        int[][] a1 = new int[][]{{2,6},{1,3},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(new Solution().merge(a1)).equals("[[1, 6], [8, 10], [15, 18]]"));
        a1 = new int[][]{{1,4},{4,5}};
        System.out.println(Arrays.deepToString(new Solution().merge(a1)).equals("[[1, 5]]"));
        a1 = new int[][]{{2,6},{1,3},{8,17},{15,18}};
        System.out.println(Arrays.deepToString(new Solution().merge(a1)).equals("[[1, 6], [8, 18]]"));
        a1 = new int[][]{{2,6}};
        System.out.println(Arrays.deepToString(new Solution().merge(a1)).equals("[[2, 6]]"));
        a1 = new int[][]{{2,6},{2,6}};
        System.out.println(Arrays.deepToString(new Solution().merge(a1)).equals("[[2, 6]]"));

    }

}