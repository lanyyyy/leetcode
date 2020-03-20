package a300_MostLongSeq;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = new int[]{2,1,1,3,5,1,9,5,10};
//        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = new int[]{4,10,4,3,8,9};
        System.out.println(new Solution().lengthOfLIS(nums));
        new Solution().lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        return dynamic(nums);
    }

    /**
     * 动态规划
     *
     * @param nums 数组
     * @return 长度
     */
    public int dynamic(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] lenth = new int[nums.length];
        lenth[0] = 1;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tempMax = Math.max(tempMax, lenth[j]);
                }
            }
            lenth[i] = tempMax + 1;
            result = Math.max(result, lenth[i]);
        }
        return result;
    }
}
