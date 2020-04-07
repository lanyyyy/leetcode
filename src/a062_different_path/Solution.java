package a062_different_path;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3,2) == 3);
        System.out.println(solution.uniquePaths(1,1) == 1);
        System.out.println(solution.uniquePaths(1,2) == 1);
        System.out.println(solution.uniquePaths(2,1) == 1);
        System.out.println(solution.uniquePaths(3,3) == 1);
    }

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        return dpSelf(m, n);
    }

    /**
     * 分析：按照二维dp算法；dp[i][j] = dp[i-1][j] + dp[i][j-1]: 如果j-1和i-1都存在的话
     *
     * @param m
     * @param n
     * @return
     */
    private int dpSelf(int m, int n) {
        int[][] dp = new int[n][m];
        // 起始点为0，0，终点为n-1,m-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
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
