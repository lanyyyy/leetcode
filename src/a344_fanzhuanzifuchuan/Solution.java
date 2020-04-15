package a344_fanzhuanzifuchuan;

public class Solution {
    public void reverseString(char[] s) {
        char c;
        for (int i = 0; i < s.length; i++) {
            if (i <= s.length - i - 1) {
                c = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = c;
            } else {
                break;
            }
        }

    }

}
