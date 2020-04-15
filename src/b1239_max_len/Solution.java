package b1239_max_len;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution so = new Solution();
//        System.out.println(so.maxLength(Arrays.asList("ab", "cd", "cde", "cdef", "efg", "fgh", "abxyz")) == 11);
//        System.out.println(so.maxLength(Arrays.asList("ab", "abcde", "cd", "ef", "gh", "ij", "kl", "ut")) == 14);
//        System.out.println(so.maxLength(Arrays.asList("ab", "abcdehijkl", "cd", "ef", "gh", "ij", "kl", "ut")) == 14);
//        System.out.println(so.maxLength(Arrays.asList("ab", "abcdehijkl", "cd", "ef", "gh", "ij", "kl", "ut")) == 14);
//        System.out.println(so.maxLength(Arrays.asList("ab", "abcdehijkl", "m", "cd", "ef", "gh", "ij", "kl", "ut")) == 15);
//
//        System.out.println(so.maxLength(Arrays.asList("abcdehijkl", "ab", "cd", "ef", "gh", "ij", "kl", "ut")) == 14);
//        System.out.println(so.maxLength(Arrays.asList("ab", "abcdehijkl", "cde", "ef", "gh", "ij", "kl", "ut")) == 13);

        System.out.println(so.maxLength(Arrays.asList("aab", "ccd", "fe")) == 2);
        System.out.println(so.maxLength(Arrays.asList("ab", "cd", "fe")) == 6);
        System.out.println(so.maxLength(Arrays.asList("ab", "ab", "ffe")) == 2);
        System.out.println(so.maxLength(Arrays.asList("ab", "cd", "cd")) == 4);
        System.out.println(so.maxLength(Arrays.asList("ab", "abcde", "cd")) == 5);
        System.out.println(so.maxLength(Arrays.asList("ab", "cdcccccccc", "cd")) == 4);
        System.out.println(so.maxLength(Arrays.asList("ab", "abcdefghijk", "cd", "ef", "gh", "i")) == 11);
        System.out.println(so.maxLength(Arrays.asList("ab", "abcdef", "hijk")) == 10);
        System.out.println(so.maxLength(Arrays.asList("ab", "abcdef", "hijk", "efg")) == 10);
        System.out.println(so.maxLength(Arrays.asList("abxyz", "cdcccccccc", "cd")) == 7);
        System.out.println(so.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")) == 26);
        System.out.println(so.maxLength(Arrays.asList("cha", "r", "act", "ers")) == 6);
        System.out.println(so.maxLength(Arrays.asList()) == 0);
        System.out.println(so.maxLength(Arrays.asList("un", "iq", "ue")) == 4);


    }


    private static Map<Character, Integer> map = new HashMap<>();

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        getMap();
        return dfs(arr, 0, 0);
    }

    private int dfs(List<String> arr, int start, int bitMask) {
        int ans = 0;
        for (int i = start; i < arr.size(); i++) {
            int x = transferStrtoInt(arr.get(i));
            if ((x & bitMask) == 0 && x != 0) {
                int re = dfs(arr, i + 1, x | bitMask) + arr.get(i).length();
                ans = Math.max(ans, re);
            }
        }
        return ans;
    }

    private int transferStrtoInt(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int bitNum = 0;
        for (char c : chars) {
            if (set.contains(c)) {
                return 0;
            } else {
                set.add(c);
                bitNum |= map.get(c);
            }
        }
        return bitNum;
    }

//    private List<Integer> transferList(List<String> arr) {
//
//        List<Integer> integers = new ArrayList<>();
//        for (String s: arr) {
//            char[] chars = s.toCharArray();
//            HashSet<Character> set = new HashSet<>();
//            int bitNum = 0;
//            for (char c : chars) {
//                if (set.contains(c)) {
//                    integers.add(0);
//                    break;
//                } else {
//                    set.add(c);
//                    bitNum |= map.get(c);
//                }
//            }
//            integers.add(bitNum);
//        }
//
//
//
//        arr.stream().map(e -> {
//
//        }).collect(Collectors.toList());
//        return integers;
//    }

    private void getMap() {
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), 1 << i);
        }
    }

}
