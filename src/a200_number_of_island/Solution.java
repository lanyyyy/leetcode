package a200_number_of_island;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIslands(new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}}) == 1);
        System.out.println(solution.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}) == 1);
        System.out.println(solution.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}}) == 2);
        System.out.println(solution.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}}) == 3);
        System.out.println(solution.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '1'}}) == 2);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        boolean isSearched[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!isSearched[i][j] && grid[i][j] == '1') {
                    bfs(grid, isSearched, i, j);
                    count++;
                }
            }
        }
        return count;

    }

    /**
     * 方法1：广度优先搜索
     */
    private boolean bfs(char[][] grid, boolean isSearched[][], int x, int y) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            if (isSearched[p[0]][p[1]]) continue;
            isSearched[p[0]][p[1]] = true;
            if (grid[p[0]][p[1]] == '0') {
                continue;
            }
            if (p[0] > 0 && !isSearched[p[0] - 1][p[1]]) {
                stack.push(new int[]{p[0] - 1, p[1]});
            }
            if (p[1] > 0 && !isSearched[p[0]][p[1] - 1]) {
                stack.push(new int[]{p[0], p[1] - 1});
            }
            if (p[0] < xLen - 1 && !isSearched[p[0] + 1][p[1]]) {
                stack.push(new int[]{p[0] + 1, p[1]});
            }
            if (p[1] < yLen - 1 && !isSearched[p[0]][p[1] + 1]) {
                stack.push(new int[]{p[0], p[1] + 1});
            }
        }
        return true;
    }
}
