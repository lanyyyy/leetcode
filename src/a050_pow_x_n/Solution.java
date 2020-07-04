package a050_pow_x_n;

import java.math.BigDecimal;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000, 10));
        System.out.println(solution.myPow(2.10000, 3));
    }

    public double myPow(double x, int n) {
        return Math.pow(x, n);
        //return mySelf(x, n);
    }

    private double mySelf(double x, int n) {
        BigDecimal bigDecimal = new BigDecimal(x);
        BigDecimal pow = bigDecimal.pow(n);
        return pow.doubleValue();
    }
}
