package a136_only_once_digital;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
//        return doWithMap(nums);
//        return doWithAlgo(nums);
        return doWithBit(nums);
    }

    /**
     * 方法3：使用位操作：同样的数位操作后位0
     * 效率：超高，击败：99%的人
     * @param nums
     * @return
     */
    private int doWithBit(int[] nums) {
        int total = 0;
        for (int i: nums) {
            total = total ^ i;
        }
        return total;
    }

    /**
     * 方法2：使用数学算法
     * 效率：比hashmap效率稍高一点，击败30%
     * @param nums
     * @return
     */
    private int doWithAlgo(int[] nums) {
        int total = 0;
        int total1 = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                total += nums[i];
            }
            total1 += nums[i];
        }
        return total * 2 - total1;
    }

    /**
     * 方法1：使用map，但是不满足题目要求，会有额外空间，并且效率不高
     * 效率：只能击败12%的人
     *
     * @param nums
     * @return
     */
    private int doWithMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
