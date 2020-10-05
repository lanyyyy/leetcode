package Sord;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A01 {

    public static void main(String[] args) {
        System.out.println(new A01().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public int findRepeatNumber(int[] nums) {
        return findOne2(nums);
    }

    private int findOne(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], null) != null) {
                return nums[i];
            } else {
                map.put(i, 1);
            }
        }
        return 0;
    }

    private int findOne2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean add = set.add(nums[i]);
            if (!add) {
                return nums[i];
            }
        }
        return 0;
    }
}
