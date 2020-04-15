package a542_01matrix;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.updateMatrix(new int[][]{{0, 1}, {1, 1}})));
        System.out.println(Arrays.deepToString(solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));

    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

//        doBfsFromOne(matrix);
        doBfsFromZero(matrix);

        return matrix;
    }

    /**
     * 方法2：从0处开始搜索，只需要1遍就可以搜索完成
     * @param matrix
     */
    private void doBfsFromZero(int[][] matrix) {
        LinkedBlockingDeque<int[]> linkedBlockingDeque = new LinkedBlockingDeque<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    linkedBlockingDeque.add(new int[]{i,j,0});
                }
            }
        }
        // 存3个：x,y,step
        boolean[][] isSearched = new boolean[matrix.length][matrix[0].length];
        int xLen = matrix.length;
        int yLen = matrix[0].length;

        while (!linkedBlockingDeque.isEmpty()) {
            int[] element = linkedBlockingDeque.pop();
            isSearched[element[0]][element[1]] = true;
            if (matrix[element[0]][element[1]] != 0) {
                matrix[element[0]][element[1]] = element[2];
            }
            if (element[0] > 0 && !isSearched[element[0] - 1][element[1]]) {
                linkedBlockingDeque.add(new int[]{element[0] - 1, element[1], element[2] + 1});
                isSearched[element[0] - 1][element[1]] = true;
            }
            if (element[0] < xLen - 1 && !isSearched[element[0] + 1][element[1]]) {
                linkedBlockingDeque.add(new int[]{element[0] + 1, element[1], element[2] + 1});
                isSearched[element[0] + 1][element[1]] = true;
            }
            if (element[1] > 0 && !isSearched[element[0]][element[1] - 1]) {
                linkedBlockingDeque.add(new int[]{element[0], element[1] - 1, element[2] + 1});
                isSearched[element[0]][element[1] - 1] = true;
            }
            if (element[1] < yLen - 1 && !isSearched[element[0]][element[1] + 1]) {
                linkedBlockingDeque.add(new int[]{element[0], element[1] + 1, element[2] + 1});
                isSearched[element[0]][element[1] + 1] = true;
            }

        }

    }


    /**
     * 方法1：按照非0开始搜索，会反复计算，导致超时
     * @param matrix
     */
    private void doBfsFromOne(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    doSearch(matrix, i, j);
                }

            }
        }
    }


    private void doSearch(int[][] matrix, int x, int y) {
        // 存3个：x,y,step
        LinkedBlockingDeque<int[]> linkedBlockingDeque = new LinkedBlockingDeque<>();
        boolean[][] isSearched = new boolean[matrix.length][matrix[0].length];
        isSearched[x][y] = true;

        int xLen = matrix.length;
        int yLen = matrix[0].length;
        int step = 0;

        linkedBlockingDeque.add(new int[]{x, y, step});
        while (!linkedBlockingDeque.isEmpty()) {
            int[] element = linkedBlockingDeque.pop();
            if (matrix[element[0]][element[1]] == 0) {
                matrix[x][y] = element[2];
                return;
            }
            if (element[0] > 0 && !isSearched[element[0] - 1][element[1]]) {
                linkedBlockingDeque.add(new int[]{element[0] - 1, y, element[2] + 1});
                isSearched[element[0] - 1][element[1]] = true;
            }
            if (element[0] < xLen - 1 && !isSearched[element[0] + 1][element[1]]) {
                linkedBlockingDeque.add(new int[]{element[0] + 1, y, element[2] + 1});
                isSearched[element[0] + 1][element[1]] = true;
            }
            if (element[1] > 0 && !isSearched[element[0]][element[1] - 1]) {
                linkedBlockingDeque.add(new int[]{element[0], element[1] - 1, element[2] + 1});
                isSearched[element[0]][element[1] - 1] = true;
            }
            if (element[1] < yLen - 1 && !isSearched[element[0]][element[1] + 1]) {
                linkedBlockingDeque.add(new int[]{element[0], element[1] + 1, element[2] + 1});
                isSearched[element[0]][element[1] + 1] = true;
            }

        }

    }
}
