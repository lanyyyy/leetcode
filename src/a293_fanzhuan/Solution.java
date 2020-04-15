package a293_fanzhuan;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generatePossibleNextMoves("++++"));
    }

    public List<String> generatePossibleNextMoves(String s) {
        if (s == null || s.length() <= 1) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int start = 0;
        while (start < s.length() - 1) {
            if (s.charAt(start) == '+' && s.charAt(start + 1) == '+') {
                // 这块直接相加，效率可能会比较低，可以使用stringbuffer
                result.add(s.substring(0, start) + "--" + s.substring(start + 2, s.length()));
            }
            start++;
        }
        return result;

    }
}
