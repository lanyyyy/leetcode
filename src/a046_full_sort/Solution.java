package a046_full_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    private static List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        doCal(nums, 0);
        return result;
    }

    private void doCal(int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            doRepliace(nums, index, i);
            doCal(nums, index + 1);
            doRepliace(nums, i, index);
        }
    }

    private void doRepliace(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
