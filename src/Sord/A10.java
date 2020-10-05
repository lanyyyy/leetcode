package Sord;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class A10 {
    public static void main(String[] args) {
        System.out.println(fib(48));
        System.out.println(fib(49));
        System.out.println(Integer.MAX_VALUE);
        PriorityQueue<Integer> queue = new PriorityQueue<>();


    }

    // 真正笔试的时候，千万不要写递归，否则就掉到沟里去了
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int fib(int n) {
        if (n <= 1) {
            map.put(n, n);
            return map.get(n);
        }
        if (map.getOrDefault(n, null) != null) {
            return map.get(n);
        }
        int val = (fib(n-1) + fib(n-2)) % 10_0000_0007;
        if (map.getOrDefault(n, null) == null) {
            map.put(n, val);
        }
        return val;
    }
}
