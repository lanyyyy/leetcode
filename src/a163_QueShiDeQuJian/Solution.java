package a163_QueShiDeQuJian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99).toString().equals("[2, 4->49, 51->74, 76->99]"));
//        System.out.println(solution.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 50, 99).toString().equals("[51->74, 76->99]"));
//        System.out.println(solution.findMissingRanges(new int[]{1, 3, 50, 75}, 0, 99).toString().equals("[0, 2, 4->49, 51->74, 76->99]"));
//        System.out.println(solution.findMissingRanges(new int[]{0, 0, 0, 50, 75}, 0, 99).toString().equals("[1->49, 51->74, 76->99]"));
//        System.out.println(solution.findMissingRanges(new int[]{0, 0, 0, 50, 75}, 0, 0).toString().equals("[]"));
        System.out.println(solution.findMissingRanges(new int[]{0, 0, 0, 50, 75}, 4, 4).toString().equals("[4]"));
        System.out.println(solution.findMissingRanges(new int[]{0, 0, 0}, 0, 99).toString().equals("[1->99]"));
        System.out.println(solution.findMissingRanges(new int[]{1}, 0, 99).toString().equals("[0, 2->99]"));
        System.out.println(solution.findMissingRanges(new int[]{200}, 0, 99).toString().equals("[0->99]"));
        System.out.println(solution.findMissingRanges(new int[]{-1}, 0, 99).toString().equals("[0->99]"));
        System.out.println(solution.findMissingRanges(new int[]{0}, 0, 99).toString().equals("[1->99]"));
        System.out.println(solution.findMissingRanges(new int[]{}, 0, 99).toString().equals("[0->99]"));
        System.out.println(solution.findMissingRanges(new int[]{}, 0, 99).toString().equals("[0->99]"));
        System.out.println(solution.findMissingRanges(new int[]{0, 0, 0, 50, 75}, 0, 99).toString().equals("[1->49, 51->74, 76->99]"));
        System.out.println(solution.findMissingRanges(new int[]{0, 0, 0, 50, 75}, 0, 99).toString().equals("[1->49, 51->74, 76->99]"));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        return getMissingRange(nums, lower, upper);
    }

    private List<String> getMissingRange(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(lower + "->" + upper);
            return result;
        }
        if (lower <= nums[0] && upper >= nums[0]) {
            addToResult(getRange(lower - 1, nums[0], lower - 1, upper), result);
        } else if (upper < nums[0] || lower > nums[nums.length - 1]) {
            result.add(lower + "->" + upper);
            return result;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            addToResult(getRange(nums[i], nums[i + 1], lower, upper), result);

        }

        if (upper >= nums[nums.length - 1]) {
            addToResult(getRange(nums[nums.length - 1], upper + 1, lower, upper + 1), result);
        }
        return result;
    }

    private void addToResult(String range, List<String> result) {
        if (!range.equals("")) {
            result.add(range);
        }
    }

    private String getRange(int start, int end, int lower, int supper) {
        if (end <= lower) {
            return "";
        } else if (start >= supper) {
            return "";
        }
        if (start >= lower && end <= supper) {
            return cal(start, end);
        } else if (start <= lower && end >= lower) {
            if (end <= supper) {
                return cal(start, end);
            } else {
                return cal(start, supper);
            }
        } else if (start <= supper && end >= supper) {
            return cal(start, supper);
        }
        return "";

    }

    private String cal(int start, int end) {
        int cha = end - start;
        if (cha == 0 || cha == 1) {
            return "";
        } else if (end - start == 2) {
            return Integer.toString(start + 1);
        }
        return (start + 1) + "->" + (end - 1);
    }
}
