package a097_find_town_law;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int findJudge2(int N, int[][] trust) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            if (trust[i][0] > N || trust[i][0] <= 0) {
                return -1;
            }
            if (trust[i][1] > N || trust[i][1] <= 0) {
                return -1;
            }
            if (map.getOrDefault(trust[i][0], null) == null) {
                map.put(trust[i][0], new ArrayList<>());
            }
            map.get(trust[i][0]).add(trust[i][1]);
        }
        // 开始判断
        // 如果size小于N-1，至少有2个人不信任
        if (map.keySet().size() < N - 1 || N <= 0) {
            return -1;
        }
        // 找到法官的位置
        int law = -1;
        for (int i = 1; i <= N; i++) {
            if (map.getOrDefault(i, null) == null) {
                law = i;
            }
        }
        // 判断具体的law位置
        for (Integer integer : map.keySet()) {
            if (!map.get(integer).contains(law)) {
                return -1;
            }
        }
        return law;

    }

    public int findJudge(int N, int[][] trust) {
        int[] degree = new int[N + 1];
        for (int i = 1; i < degree.length; i++) {
            degree[i] = 0;
        }
        for (int i = 0; i < trust.length; i++) {
            degree[trust[i][0]] = degree[trust[i][0]] - 1;
            degree[trust[i][1]] = degree[trust[i][1]] + 1;
        }

        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == N -1) {
                return i;
            }
        }
        return -1;
    }


}
