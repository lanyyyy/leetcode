package a033_search_shuzu;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7) == 3);
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) == 4);
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 10) == -1);
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, -1) == -1);
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3) == -1);
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2) == 6);
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4) == 0);
        System.out.println(solution.search(new int[]{}, 3) == -1);
        System.out.println(solution.search(new int[]{1, 2}, 3) == -1);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return doSerach(nums, target, 0, nums.length - 1);
    }

    private int doSerach(int[] nums, int target, int start, int end) {
        if (end - start <= 2) {
            for (int i = start; i <= end; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }

        int middle = (end + start) / 2;
        // 判断一下，如果在升序中间，则在升序中搜索，否则在混序中
        // 升序
        if (nums[start] < nums[end] && target >= nums[start] && target < nums[end]) {
            if (target >= nums[middle]) {
                return doSerach(nums, target, middle, end);
            } else {
                return doSerach(nums, target, start, middle);
            }
            //  else是降序的场景
        } else {
            if (nums[start] < nums[middle] && target >= nums[start] && target <= nums[middle]) {
                return doSerach(nums, target, start, middle);
            } else if (nums[middle] < nums[end] && target >= nums[middle] && target <= nums[end]) {
                return doSerach(nums, target, middle, end);
            } else if (nums[start] > nums[middle]) {
                return doSerach(nums, target, start, middle);
            } else if (nums[middle] > nums[end]) {
                return doSerach(nums, target, middle, end);
            }
            return -1;
        }
    }
}
