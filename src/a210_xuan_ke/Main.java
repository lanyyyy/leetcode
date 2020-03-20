package a210_xuan_ke;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int courseNum = 2;
        int[][] deps = new int[][]{{1, 0},{0, 1}};
//        System.out.println(Arrays.toString(solution.findOrder(courseNum, deps)));

//        courseNum = 2;
//        deps = new int[][]{{0, 1}};
//        System.out.println(Arrays.toString(solution.findOrder(courseNum, deps)));
//
//        courseNum = 2;
//        deps = new int[][]{{1, 0}};
//        System.out.println(Arrays.toString(solution.findOrder(courseNum, deps)));

        courseNum = 4;
        deps = new int[][]{{1, 0},{2, 0},{3, 1},{3, 2}};
        System.out.println(Arrays.toString(solution.findOrder(courseNum, deps)));

//        courseNum = 6;
//        deps = new int[][]{{1, 0},{2, 0},{3, 1},{3, 2}};
//        System.out.println(Arrays.toString(solution.findOrder(courseNum, deps)));
//
//        courseNum = 6;
//        deps = new int[][]{};
//        System.out.println(Arrays.toString(solution.findOrder(courseNum, deps)));
//
//        courseNum = 6;
//        deps = new int[][]{{1, 0},{2, 0},{3, 1},{1, 3}};
//        System.out.println(Arrays.toString(solution.findOrder(courseNum, deps)));
    }
}
