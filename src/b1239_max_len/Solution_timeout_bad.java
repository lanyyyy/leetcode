package b1239_max_len;

import java.util.*;

public class Solution_timeout_bad {

    public static void main(String[] args) {
        Solution_timeout_bad solutionTimeoutbad = new Solution_timeout_bad();
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "cd", "cde", "cdef", "efg", "fgh", "abxyz")) == 11);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "abcde", "cd", "ef", "gh", "ij", "kl", "ut")) == 14);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "abcdehijkl", "cd", "ef", "gh", "ij", "kl", "ut")) == 14);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "abcdehijkl", "cd", "ef", "gh", "ij", "kl", "ut")) == 14);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "abcdehijkl", "m", "cd", "ef", "gh", "ij", "kl", "ut")) == 15);

        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("abcdehijkl", "ab", "cd", "ef", "gh", "ij", "kl", "ut")) == 14);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "abcdehijkl", "cde", "ef", "gh", "ij", "kl", "ut")) == 13);

        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("aab", "ccd", "fe")) == 2);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "cd", "fe")) == 6);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "ab", "ffe")) == 2);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "cd", "cd")) == 4);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "abcde", "cd")) == 5);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "cdcccccccc", "cd")) == 4);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "abcdefghijk", "cd", "ef", "gh", "i")) == 11);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "abcdef", "hijk")) == 10);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("ab", "abcdef", "hijk", "efg")) == 10);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("abxyz", "cdcccccccc", "cd")) == 7);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")) == 26);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("cha", "r", "act", "ers")) == 6);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList()) == 0);
        System.out.println(solutionTimeoutbad.maxLength(Arrays.asList("un", "iq", "ue")) == 4);


    }

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        List<String> tmp = checkStrIllgal(arr);

        tmp.sort((o1, o2) -> o1.length() - o2.length());
        int len = dfs(tmp, null, "");
        return len;
    }

    /**
     * 备注：这里不能用动态规划，因为子问题的最优解是不固定的
     * 按照原有的解法，会超时，需要重新规划
     * @param arr
     * @param isSearched
     * @param now
     * @return
     */
    private int dfs(List<String> arr, boolean[] isSearched, String now) {
        if (isSearched == null) {
            isSearched = new boolean[arr.size()];
        }
        if (hasReplicateChar(now)) {
            return 0;
        }
        int lenR = now.length();
        if (!isAllsearched(isSearched)) {
            for (int i = 0; i < isSearched.length; i++) {
                isSearched[i] = true;
                int len = dfs(arr, isSearched, now + arr.get(i));
                lenR = Math.max(len, lenR);
                isSearched[i] = false;
            }
        }
        return lenR;

    }

    private boolean isAllsearched(boolean[] isSearched) {
        for (int i = 0; i < isSearched.length; i++) {
            if (!isSearched[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean hasReplicateChar(String s) {
        if (s.length() > 26) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            if (map.getOrDefault(s.charAt(j), null) == null) {
                map.put(s.charAt(j), 1);
            } else {
                return true;
            }
        }
        return false;
    }


    private List<String> checkStrIllgal(List<String> arr) {
        List<String> x = new ArrayList<>(arr);
        x.removeIf(this::hasReplicateChar);
        return x;
    }


}