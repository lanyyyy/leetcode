package a053_max_sub_sum;


public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6);

    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
//        return tanxin(nums);
        return kanadeAlgo(nums);
    }

    private int kanadeAlgo(int[] nums) {
        int maxLen = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i-1];
            }
            maxLen = Math.max(nums[i], maxLen);
        }
        return maxLen;

    }

    /**
     * 贪心算法，线性时间
     *
     * @param nums 数组
     * @return 长度和
     */
    private int tanxin(int[] nums) {
        int max_ending_here = nums[0];
        int max_so_far = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_ending_here = Math.max(max_ending_here + nums[i], nums[i]);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }
}
