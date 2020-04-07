package a063_different_path_2;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        return dpSelf(obstacleGrid);

    }

    /**
     * 分析：按照二维dp算法；dp[i][j] = dp[i-1][j] + dp[i][j-1]: 如果j-1和i-1都存在的话
     * @return
     */
    private int dpSelf(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        // 起始点为0，0，终点为n-1,m-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                }
                if (i > 0) {
                    dp[i][j] += dp[i-1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j-1];
                }

            }
        }

        return dp[n-1][m-1];
    }
}
