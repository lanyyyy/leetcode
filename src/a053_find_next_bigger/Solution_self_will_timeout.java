package a053_find_next_bigger;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_self_will_timeout {

    public static void main(String[] args) {
        Solution_self_will_timeout solutionSelfwilltimeout = new Solution_self_will_timeout();
        System.out.println(Arrays.toString(solutionSelfwilltimeout.nextGreaterElements(new int[]{1})).equals("[-1]"));
        System.out.println(Arrays.toString(solutionSelfwilltimeout.nextGreaterElements(new int[]{1, 2, 1})).equals("[2, -1, 2]"));
        System.out.println(Arrays.toString(solutionSelfwilltimeout.nextGreaterElements(new int[]{1, 1})).equals("[-1, -1]"));
        System.out.println(Arrays.toString(solutionSelfwilltimeout.nextGreaterElements(new int[]{1, 1, 1})).equals("[-1, -1, -1]"));
        System.out.println(Arrays.toString(solutionSelfwilltimeout.nextGreaterElements(new int[]{1, 2, 3})).equals("[2, 3, -1]"));
        System.out.println(Arrays.toString(solutionSelfwilltimeout.nextGreaterElements(new int[]{3, 2, 1})).equals("[-1, 3, 3]"));
    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        if (nums.length == 1) {
            return new int[]{-1};
        }
        return doCal(nums);
    }

    private int[] doCal(int[] nums) {
        // 初始化result并置为-1
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < nums.length; i++) {
            if (queue.isEmpty()) {
                queue.add(new int[]{nums[i], i});
            } else {
                getResult(result, queue, nums[i]);
                queue.add(new int[]{nums[i], i});
            }
        }

        for (int i = 0; i < nums.length; i++) {
            getResult(result, queue, nums[i]);

        }
        return result;
    }

    private void getResult(int[] result, PriorityQueue<int[]> queue, int num) {
        while (!queue.isEmpty() && queue.peek()[0] < num) {
            int[] tmp = queue.poll();
            result[tmp[1]] = num;
        }
    }
}
