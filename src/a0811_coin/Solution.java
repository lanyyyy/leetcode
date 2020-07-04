package a0811_coin;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.waysToChange(5) == 2);
        System.out.println(solution.waysToChange(10) == 4);
    }

    public int waysToChange(int n) {
        if (n <= 0) {
            return 0;
        }
        return doCal(n);
    }

    private int doCal(int n) {
        int count = 0;
        int a1 = 25;
        int a2 = 10;
        int a3 = 5;
        int n1 = n / a1;
        for (int i1 = 0; i1 <= n1; i1++) {
            int total1 = i1 * a1;
            if (total1 == n) {
                count++;
                continue;
            }
            int n2 = (n - total1) / a2;

            for (int i2 = 0; i2 <= n2; i2++) {
                int total2 = i2 * a2;
                if (total2 + total1 == n) {
                    count++;
                    continue;
                }

                int n3 = (n - total1 - total2) / a3;

                for (int i3 = 0; i3 <= n3; i3++) {
                    count++;
                }
            }
        }
        return count;
    }

}
