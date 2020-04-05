package a005_Max_Huiwen;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(solution.longestPalindrome("aba").equals("aba"));
        System.out.println(solution.longestPalindrome("abad").equals("aba"));
        System.out.println(solution.longestPalindrome("caba").equals("aba"));
        System.out.println(solution.longestPalindrome("bb").equals("bb"));
        System.out.println(solution.longestPalindrome("abb").equals("bb"));
        System.out.println(solution.longestPalindrome("1234abcddcba").equals("abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(solution.longestPalindrome("1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba1234abcddcba"));
        System.out.println(System.currentTimeMillis() - start);
    }

    public String longestPalindrome(String s) {
//        return CenterExpand(s);
        return dpCal(s);
    }

    private String dpCal(String s) {
        if (s == null || s.length() == 0) {
            return "";
        } else if (s.length() == 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int end = 0;
        int maxLen = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩散法（后面跟动态规划方式比较一下时间）
     *
     * @param s 入参
     * @return 回文
     */
    private String CenterExpand(String s) {
        if (s == null || s.length() == 0) {
            return "";
        } else if (s.length() == 1) {
            return s;
        }
        int left;
        int right;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = i;
            while (left > 0 && s.charAt(left - 1) == s.charAt(left)) {
                left--;
            }
            while (right < s.length() - 1 && s.charAt(right + 1) == s.charAt(right)) {
                right++;
            }
            while (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }
            if ((right - left) > (end - start)) {
                start = left;
                end = right;
            }
        }
        return s.substring(start, end + 1);
    }
}