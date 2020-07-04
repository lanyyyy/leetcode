package b1349_max_student_seats;

public class Solution {
    public static void main(String[] args) {

    }

    public int maxStudents(char[][] seats) {
        if (seats == null || seats.length == 0) {
            return 0;
        }
        return 0;

    }

    /**
     * 方法1：动态规划：自己的第一次想法：
     * 用2个矩阵：m1, dp
     * m1: 存储位置上是否有坐人
     * dp：存储dp
     *
     * @return 结果
     */
    private int doFirst(char[][] seats, boolean[][] isSeat) {
        //if (isSeat == null) {
        //    isSeat = new boolean[seats.length][seats[0].length];
        //}
        //int[][] dp = new int[seats.length][seats[0].length];
        //
        //if (isTrue(seats[0][0])) {
        //    dp[0][0] = 0;
        //    isSeat[0][0] = false;
        //} else {
        //    dp[0][0] = 1;
        //    isSeat[0][0] = true;
        //}
        //
        //for (int i = 0; i < seats.length; i++) {
        //    for (int j = 0; j < seats[0].length; j++) {
        //
        //    }
        //
        //}
        return 0;

    }

    // 判断当前点是否能坐人
    private boolean isTrue(char[][] seats, boolean[][] isSeat, int x, int y) {
        if (x == 0) {
            if (y == 0) {
                return canSit(seats[x][y], isSeat[x][y]);
            } else {
                return canSit(seats[x][y], isSeat[x][y]) && canSit(seats[x][y - 1], isSeat[x][y - 1]);
            }
        }
        if (y == 0) {
            return canSit(seats[x][y], isSeat[x][y]) && canSit(seats[x - 1][y], isSeat[x - 1][y]);
        }
        return canSit(seats[x][y], isSeat[x][y]) &&
                canSit(seats[x - 1][y], isSeat[x - 1][y]) &&
                canSit(seats[x - 1][y - 1], isSeat[x][y - 1]);

    }

    private boolean canSit(char c, boolean isSeat) {
        if ('#' == c) {
            return false;
        }
        return isSeat;
    }
}
