package a003_no_repeat_longest_str;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("tmmzuxt") == 5);
        //System.out.println(solution.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(solution.lengthOfLongestSubstring("aabaab!bb") == 3);
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(solution.lengthOfLongestSubstring("eabcabcbb") == 4);
        System.out.println(solution.lengthOfLongestSubstring("") == 0);
        System.out.println(solution.lengthOfLongestSubstring("a") == 1);
        System.out.println(solution.lengthOfLongestSubstring("aaaaa") == 1);
        System.out.println(solution.lengthOfLongestSubstring("aaaab") == 2);
        System.out.println(solution.lengthOfLongestSubstring("baaab") == 2);
        System.out.println(solution.lengthOfLongestSubstring("abcdefg") == 7);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        //return doublePoint(s);  // 字节的解法，还不够精简
        return moreEffency(s);

    }


    /**
     * 参考答案的精简：提升了约30%的时间效率
     * 利用双指针算法：
     *
     * @param s 目标串
     * @return int
     */
    private int moreEffency(String s) {
        int start = 0;
        int result = 0;
        // 这里考虑用hashMap缓存一下
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            // 之前已经有了
            if (map.putIfAbsent(s.charAt(end), end) != null) {
                // 直接更新start
                start = Math.max(map.get(s.charAt(end)), start);
            }
            result = Math.max(result, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return result;

    }

    /**
     * 自己的算法
     * 利用双指针算法：
     *
     * @param s 目标串
     * @return int
     */
    private int doublePoint(String s) {
        int start = 0;
        int end = 0;
        int result = 0;
        // 这里考虑用hashMap缓存一下
        Map<Character, Integer> map = new HashMap<>();
        int tmpResult = 0;
        while (end < s.length()) {
            // 返回null，则说明之前没放过
            while (end < s.length() && map.putIfAbsent(s.charAt(end), end) == null) {
                // 计数+1
                tmpResult++;
                // 右移一位
                end++;
            }

            result = Math.max(result, tmpResult);
            // end结束，返回result
            if (end != s.length()) {
                // end没结束，有重复的，开始清理：
                while (start < end) {
                    tmpResult--;
                    if (s.charAt(start) != s.charAt(end)) {
                        map.remove(s.charAt(start));
                        start++;
                    } else {
                        map.remove(s.charAt(start));
                        start++;
                        break;
                    }
                }
            }

        }
        return result;

    }
}


