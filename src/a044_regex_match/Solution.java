package a044_regex_match;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(!isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
        System.out.println(!isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
        System.out.println(!isMatch("b", "*?dd"));
        System.out.println(!isMatch("adceb", "*a*?dd"));
        System.out.println(isMatch("ho", "ho**"));
        System.out.println(!isMatch("h*o", "ho**"));
        System.out.println(isMatch("hot", "ho**"));
        System.out.println(!isMatch("ho", "ho*?"));
        System.out.println(!isMatch("ho", "ho*??"));
        System.out.println(isMatch("ho", "h?*"));
        System.out.println(isMatch("o", "**o***"));
        System.out.println(!isMatch("o", "**?o**"));
        long end = System.currentTimeMillis();
        System.out.println("times: " + (end - start));

//        long start = System.currentTimeMillis();
//        String subPattern = "a*******b";
//        while (subPattern.contains("**")) {
//            subPattern = subPattern.replace("**", "*");
//        }
//        System.out.println(searchWithMemory("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", subPattern));
//        long end = System.currentTimeMillis();
//        System.out.println("times: " + (end - start) / 1000);
    }

    public static boolean isMatch(String s, String p) {
        while (p.contains("**")) {
            p = p.replace("**", "*");
        }
//        return search(s, p);
//        return search(s, p);
        return searchDynamic(s, p);
//        return doublePoint(s, p);
    }

    // 双指针算法
    public static boolean doublePoint(String subStr, String subPattern) {
        if (subStr == null || subPattern == null) return false;
        if (subPattern.equals("") && subStr.equals("")) return true;
        if (subPattern.equals("") && subStr.length() > 0) return false;
        if (!subPattern.equals("*") && subStr.equals("")) return false;
        int sLen = subStr.length();
        int pLen = subPattern.length();
        int sIndex = 0;
        int pIndex = 0;
        int sStart = -1;
        int pStart = -1;
        while (sIndex < sLen) {
            if (pIndex < pLen && (subPattern.charAt(pIndex) == '?' ||
                    (subStr.charAt(sIndex) == subPattern.charAt(pIndex) && subPattern.charAt(pIndex) != '*'))) {
                sIndex++;
                pIndex++;
            } else if (pIndex < pLen && subPattern.charAt(pIndex) == '*') {
                sStart = sIndex;
                pStart = pIndex;
                pIndex++;
            } else if (sStart > -1) {
                sIndex = ++sStart;
                pIndex = pStart;
            } else {
                return false;
            }
        }
//        如果能正常匹配成功，则sIndex == sLen，并且pIndex后面的没有*号
        while (pIndex < pLen) {
            if (subPattern.charAt(pIndex) != '*') {
                return false;
            }
            pIndex++;
        }
        return true;
    }

    //    方法1：递归搜索, 队列长的时候回超出时间限制
    private static boolean search(String subStr, String subPattern) {
        if (subStr == null || subPattern == null) {
            return false;
        }
        if (subStr.length() == 1 && subPattern.length() == 1) {
            if (subStr.equals(subPattern)) {
                return true;
            } else if (subPattern.equals("*") || subPattern.equals("?")) {
                return true;
            } else {
                return false;
            }
        } else if (subStr.length() == 0) {
            if (subPattern.length() == 0) {
                return true;
            } else if (subPattern.charAt(0) != '*') {
                return false;
            } else {
                return search("", subPattern.substring(1, subPattern.length()));
            }
        } else if (subPattern.length() == 0) {
            return false;
        }
        if (subPattern.charAt(0) == '*') {
            if (subPattern.length() == 1) {
                return true;
            } else {
//                * 号不匹配字符
                if (search(subStr, subPattern.substring(1, subPattern.length()))) {
                    return true;
//                * 号匹配多个字符串
                } else if (search(subStr.substring(1, subStr.length()), subPattern)) {
                    return true;
                }

            }
        } else if (subPattern.charAt(0) == '?') {
            return search(subStr.substring(1, subStr.length()), subPattern.substring(1, subPattern.length()));
        } else if (subPattern.charAt(0) == subStr.charAt(0)) {
            return search(subStr.substring(1, subStr.length()), subPattern.substring(1, subPattern.length()));
        }
        return false;
    }

    //    方法2：使用记忆搜索
    private static Map<String, Boolean> memory = new HashMap<>();

    private static boolean searchWithMemory(String subStr, String subPattern) {
        if (subStr == null || subPattern == null) {
            return false;
        }
        if (memory.getOrDefault(subStr, null) != null) {
            return memory.get(subStr);
        }
        if (subStr.length() == 1 && subPattern.length() == 1) {
            if (subStr.equals(subPattern)) {
                return true;
            } else if (subPattern.equals("*") || subPattern.equals("?")) {
                return true;
            } else {
                return false;
            }
        } else if (subStr.length() == 0) {
            if (subPattern.length() == 0) {
                return true;
            } else if (subPattern.charAt(0) != '*') {
                return false;
            } else {
                return search("", subPattern.substring(1, subPattern.length()));
            }
        } else if (subPattern.length() == 0) {
            memory.put(subStr, false);
            return false;
        }

        if (subPattern.charAt(0) == '*') {
            if (subPattern.length() == 1) {
                memory.put(subStr, true);
                return true;
            } else {
//                * 号不匹配字符
                if (search(subStr, subPattern.substring(1, subPattern.length()))) {
                    memory.put(subStr, true);
                    return true;
//                * 号匹配多个字符串
                } else if (search(subStr.substring(1, subStr.length()), subPattern)) {
                    memory.put(subStr, true);
                    return true;
                }

            }
        } else if (subPattern.charAt(0) == '?') {
            return search(subStr.substring(1, subStr.length()), subPattern.substring(1, subPattern.length()));
        } else if (subPattern.charAt(0) == subStr.charAt(0)) {
            return search(subStr.substring(1, subStr.length()), subPattern.substring(1, subPattern.length()));
        }
        memory.put(subStr, false);
        return false;
    }

    private static boolean dp[][];

    private static boolean searchDynamic(String subStr, String subPattern) {
        if (subStr == null || subPattern == null) {
            return false;
        }
        if (subStr.length() == 0) {
            if (subPattern.length() == 0) {
                return true;
            } else if (subPattern.charAt(0) == '*') {
                return subPattern.replace('*', ' ').trim().equals("");
            } else {
                return false;
            }
        } else if (subPattern.length() == 0) {
            return false;
        }
//        dp数组，存储动态规划数组
        dp = new boolean[subPattern.length() + 1][subStr.length() + 1];
//        初始化(0,0)原点为true
        dp[0][0] = true;
        dp[0][1] = false;
        if (subPattern.charAt(0) == '*') {
            dp[1][0] = true;
        }
//        开始动态规划
        for (int i = 1; i <= subPattern.length(); i++) {
            for (int j = 1; j <= subStr.length(); j++) {
                if (subPattern.charAt(i - 1) == '*') {
//                    *匹配为空、或者为一个字符，满足一个即为true
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
                } else if (subPattern.charAt(i - 1) == '?' || subPattern.charAt(i - 1) == subStr.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (subPattern.charAt(i - 1) != subStr.charAt(j - 1)) {
                    try {
                        dp[i][j] = false;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return dp[subPattern.length()][subStr.length()];

    }

}
