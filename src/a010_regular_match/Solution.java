package a010_regular_match;

public class Solution {

    public boolean isMatch(String text, String pattern) {
//        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
//        dp[text.length()][pattern.length()] = true;
//
//        for (int i = text.length(); i >= 0; i--){
//            for (int j = pattern.length() - 1; j >= 0; j--){
//                boolean first_match = (i < text.length() &&
//                        (pattern.charAt(j) == text.charAt(i) ||
//                                pattern.charAt(j) == '.'));
//                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
//                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
//                } else {
//                    dp[i][j] = first_match && dp[i+1][j+1];
//                }
//            }
//        }
//        return dp[0][0];

        if (pattern != null) {
            while (pattern.contains("**")) {
                pattern = pattern.replace("**", "*");
            }
        }

        return dpAlgo(text, pattern);
    }

    private boolean dpAlgo(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        if (p.length() >= 2 && p.charAt(1) == '*') {
            dp[0][2] = true;
        }
        if (p.length() == 0 && s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (i == 0) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = (dp[i - 1][j - 2] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) ||
                                (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) ||
                                dp[i][j - 2];
                    }
                } else if (i > 0 && p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (i > 0 && p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("", "b*C*"));
        System.out.println(!solution.isMatch("aab", "b.*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(!solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(!solution.isMatch("mississippi", "mis*is*p*."));
//        System.out.println(solution.isMatch("abcd", "*"));
//        System.out.println(solution.isMatch("abcd", "*."));
//        System.out.println(solution.isMatch("abcd", ".*."));
//        System.out.println(solution.isMatch("abcd", "************"));
//        System.out.println(solution.isMatch("abcdeeeee", "**********ee"));
//        System.out.println(solution.isMatch("abcsssd", "******s*****"));
//        System.out.println(solution.isMatch("abcdeeeeessss", "a****..ee*******"));
//        System.out.println(solution.isMatch("abcd", "*a***.*******d"));
//        System.out.println(solution.isMatch("abcdxxxxx", "ab**********x"));
//
//
//        System.out.println(!solution.isMatch("abcd", ".*......"));
//        System.out.println(!solution.isMatch("abcd", "......************"));
//        System.out.println(!solution.isMatch("abcdeeeee", "bcd******ee"));
//        System.out.println(!solution.isMatch("abcsssd", "csd*****s*****"));
//        System.out.println(!solution.isMatch("1abcdeeeeessss", "a****..ee*******"));

    }
}
