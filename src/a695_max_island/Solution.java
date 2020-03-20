package a695_max_island;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        return 0;
    }

    private int[][] dp;

    //    动态规划搜索
    private int dpSearch(int[][] grid) {
        if (grid == null) return 0;
        if (grid.length < 3) return 0;
        dp = new int[grid.length][grid.length];
        if (grid.length == 3) {
            int sum = 0;
            for (int i=0; i< grid.length; i++) {
                for (int j=0; j< grid.length; j++) {
                    dp[i][j] = 0;
                    sum += grid[i][j];
                }
            }
            // 中心有岛屿，粒度为1
            if (sum == 1 && dp[1][1] == 1) {
                dp[2][2] = 1;
            }
        }
        return 0;
    }
}