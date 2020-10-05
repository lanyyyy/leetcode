package Sord;

public class A02 {
    public static void main(String[] args) {
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (matrix[0][0] > target || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        //return findByForce(matrix, target);
        return findByNew(matrix, target);
    }

    // 快速查找，从矩阵的右上角开始查找
    private boolean findByNew(int[][] matrix, int target) {
        // 初始化起点为右上角，开始干
        int x = matrix.length - 1;
        int y = 0;
        while (x >= 0 && y < matrix[0].length) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }

    // 不要放弃暴力算法，一般暴力都是可以解出来的
    private boolean findByForce(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[0].length; i1++) {
                if (matrix[i][i1] == target) {
                    return true;
                }
            }
        }
        return false;
    }

}
