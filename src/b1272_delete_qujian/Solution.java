package b1272_delete_qujian;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        if (intervals == null) {
            return null;
        }
        for (int i = 0; i < intervals.length; i++) {
//            在右侧
            if (intervals[i][1] <= toBeRemoved[0]) {
                getSqure(intervals[i][0], intervals[i][1], result);
//            remove在最左侧
            } else if (intervals[i][0] >= toBeRemoved[1]) {
                getSqure(intervals[i][0], intervals[i][1], result);
//            存在交集：交集存在四种情况：前交集、内包含、外包含、后交集
            } else if (intervals[i][0] <= toBeRemoved[0] && toBeRemoved[0] <= intervals[i][1]) {
//                这里有一点需要考虑：就是=0的特殊区间
//                1.1 内交集：会产生2个子集
                if (intervals[i][1] > toBeRemoved[1]) {
                    getSqure(intervals[i][0], toBeRemoved[0], result);
                    getSqure(toBeRemoved[1], intervals[i][1], result);
//                1.2 后交集：1个子集
                } else {
                    getSqure(intervals[i][0], toBeRemoved[0], result);
                }
            } else if (intervals[i][0] >= toBeRemoved[0] && intervals[i][0] <= toBeRemoved[1]) {
//                1.3 前交接：会产生1个子集
                if (intervals[i][1] > toBeRemoved[1]) {
                    getSqure(toBeRemoved[1], intervals[i][1], result);
//                1.4 外交集：则直接任何输出
                } else {
                }
            }
        }
        return result;
    }

    private void getSqure(int i, int j, List<List<Integer>> result) {
        if (i == j) {
            return;
        }
        List<Integer> req = new ArrayList<>();
        req.add(i);
        req.add(j);
        result.add(req);
    }
}
