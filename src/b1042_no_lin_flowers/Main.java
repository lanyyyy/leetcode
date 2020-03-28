package b1042_no_lin_flowers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("[1, 2, 3]".equals(Arrays.toString(solution.gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}}))));
        System.out.println("[1, 2, 1, 2]".equals(Arrays.toString(solution.gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}}))));
        System.out.println("[1, 2, 3]".equals(Arrays.toString(solution.gardenNoAdj(10000, new int[][]{}))));
//        System.out.println("[1, 2, 3]".equals(Arrays.toString(solution.gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}}))));
//        System.out.println("[1, 2, 3]".equals(Arrays.toString(solution.gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}}))));
//        System.out.println("[1, 2, 3]".equals(Arrays.toString(solution.gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}}))));
    }
}
