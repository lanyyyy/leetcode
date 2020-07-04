package a011_more_water;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

    }

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

//        return force(height);
        return doublePoint(height);
    }

    /**
     * 双指针算法，时间复杂度从指数级降低到常数级别
     */
    private int doublePoint(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int copacity = 0;
        while (start < end) {
            copacity = Math.max(copacity, (end - start) * Math.min(height[start], height[end]));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return copacity;
    }

    /**
     * 暴力解法，可以通过题解，但是太慢
     */
    private int force(int[] height) {
        int copacity = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                copacity = Math.max(copacity, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return copacity;
    }
}
