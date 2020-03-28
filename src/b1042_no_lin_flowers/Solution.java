package b1042_no_lin_flowers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这里有2点需要注意：
 * 1. 存在可能不相连的节点
 * 2. N的数目太大，有接近10000，会导致内存溢出，应该使用邻接表存储
 */
public class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        if (N == 1) {
            return new int[]{1};
        } else if (N == 2) {
            return new int[]{1, 2};
        } else if (N == 3) {
            return new int[]{1, 2, 3};
        }
        Map<Integer, List<Integer>> gardens = transferToMatrics(N, paths);

        int[] colors = new int[N + 1];

        for (int i = 1; i < colors.length; i++) {
            colors[i] = 0;
        }
        colors[1] = 1;
        for (int i = 1; i < colors.length; i++) {
            colors[i] = findColors(colors, gardens, i);
        }
        int[] result = new int[N];
        System.arraycopy(colors, 1, result, 0, result.length);

        return result;
    }

    private int findColors(int[] colors, Map<Integer, List<Integer>> gardens, int index) {
        // garden矩阵是从1开始
        List<Integer> alreaColors = new ArrayList<>();
        if (gardens.getOrDefault(index, null) == null) {
            return 1;
        }

        for (int i = 0; i < gardens.get(index).size(); i++) {
            alreaColors.add(colors[gardens.get(index).get(i)]);
        }
        return findMatch(alreaColors);
    }

    private int findMatch(List<Integer> alreaColors) {
        if (!alreaColors.contains(1)) {
            return 1;
        } else if (!alreaColors.contains(2)) {
            return 2;
        } else if (!alreaColors.contains(3)) {
            return 3;
        } else {
            return 4;
        }
    }

    private Map<Integer, List<Integer>> transferToMatrics(int N, int[][] paths) {
        Map<Integer, List<Integer>> gardens = new HashMap<>();
        for (int[] path : paths) {
            if (gardens.getOrDefault(path[0], null) == null) {
                gardens.put(path[0], new ArrayList<>());
            }
            if (gardens.getOrDefault(path[1], null) == null) {
                gardens.put(path[1], new ArrayList<>());
            }
            gardens.get(path[0]).add(path[1]);
            gardens.get(path[1]).add(path[0]);
        }
        return gardens;
    }
}