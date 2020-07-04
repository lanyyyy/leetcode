package a464_BoYiGame;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canIWin(11, 10));
        System.out.println(!solution.canIWin(11, 12));
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }

        Boolean[] memory = new Boolean[1 << (maxChoosableInteger + 1)];
        return doDfs(maxChoosableInteger, desiredTotal, 0, memory);

    }

    private boolean doDfs(int maxChoosableInteger, int total, int visited, Boolean[] memory) {
        if (memory[visited] != null) {
            return memory[visited];
        }
        if (total <= 0) {
            return false;
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            // visited & (1 << i))：表示遍历的时候，该点是不是就是visited
            // visited | 1 << i：遍历的下一个点
            if ((visited & (1 << i)) == 0 && !doDfs(maxChoosableInteger, total - i, visited | (1 << i), memory)) {
                memory[visited] = true;
                return true;
            }
        }
        memory[visited] = false;
        return memory[visited];

    }
}
