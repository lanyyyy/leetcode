package a053_max_sub_sum;


public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6);
        System.out.println(solution.maxSubArray(new int[]{-2}) == -2);
        System.out.println(solution.maxSubArray(new int[]{-2, 1}) == 1);
        System.out.println(solution.maxSubArray(new int[]{-2, -1, -3}) == -1);
        System.out.println(solution.maxSubArray(new int[]{-2, -1, -3, -4}) == -1);
        System.out.println(solution.maxSubArray(new int[]{-2, -1, -3}) == -1);

    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //return tanXin(nums);
        return dp(nums);
    }

    /**
     * 动态规划算法：result = max( f(0), f(1), ... , f(n-1) )
     * 其中: f(i)表示以i为结尾的最大和
     * f(i) = max ( f(i-1) + num[i], nums[i] )
     *
     * @param nums 目标数组
     * @return 和
     */
    private int dp(int[] nums) {
        int result = Integer.MIN_VALUE;
        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp[i] = Math.max(tmp[i-1] + nums[i], nums[i]);
        }
        for (int i = 0; i < tmp.length; i++) {
            result = Math.max(result, tmp[i]);
        }
        return result;
    }

    /**
     * 方法1：贪心算法，只取当前最大的
     * @param nums
     * @return
     */
    private int tanXin(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmp < 0) {
                tmp = nums[i];
            } else {
                tmp += nums[i];
            }
            maxValue = Math.max(tmp, maxValue);
        }
        return maxValue;

    }

}
