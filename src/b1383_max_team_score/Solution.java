package b1383_max_team_score;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxPerformance(6,
                new int[]{2, 10, 3, 1, 5, 8},
                new int[]{5, 4, 3, 9, 7, 2},
                2));

    }

    /**
     * @param n          人数
     * @param speed      速度数组
     * @param efficiency 效率数组
     * @param k          效率之和最高的人数
     * @return 效率值
     */
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Queue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            // 按照效率值从大到小排序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < efficiency.length; i++) {
            priorityQueue.add(new int[]{speed[i], efficiency[i]});
        }

        Queue<Integer> speedHeap = new PriorityQueue<>();

        long res = 0;
        long speedTotal = 0;
        for (int i = 0; i < n; i++) {
            int[] ints = priorityQueue.poll();
            speedHeap.add(ints[0]);
            speedTotal += ints[0];
            if (i < k) {
            } else {
                // 弹出最小的那个speed值，保证取得的值是最大的
                speedTotal -= speedHeap.poll();
            }
            res = Math.max(res, speedTotal * ints[1]);

        }

        return (int)(res % 1000000007);

    }
}
