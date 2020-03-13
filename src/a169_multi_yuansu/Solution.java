package a169_multi_yuansu;

import java.util.*;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 题解：
 * 方法一：利用Map的统计方式
 * 方法二：因为元素多余一半，因此可以用快速排序方法
 */
public class Solution {
    public int majorityElement(int[] nums) {
        return method3(nums);
    }

    /**
     * Map映射统计方法（适用范围更广），本题中的方式是可以投机的
     */
    public int method1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.getOrDefault(i, 0) == 0) {
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);
        }
//        System.out.println(map.toString());
        int key = 0;
        int value = 0;
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer)entry.getValue() > value) {
                value = (Integer) entry.getValue();
                key = (Integer) entry.getKey();
            }
        }
        return key;
    }

    /**
     * 使用快速排序，比较复杂
     */
    public int method2() {
//        这里暂时不实现
        return 0;
    }

    /**
     * 直接用Arrays的排序方法
     */
    public int method3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
