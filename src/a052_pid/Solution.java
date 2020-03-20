package a052_pid;

import java.util.*;

public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (ppid == null || pid == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = transfer(pid, ppid);
        List<Integer> result = new ArrayList<>();
        if (kill == 0) {
            result.addAll(pid);
            result.addAll(ppid);
            return quchong(result);
        }
        return getIntegers(kill, map, result);
    }

    private List<Integer> getIntegers(int kill, Map<Integer, List<Integer>> map, List<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        stack.push(kill);
        while (!stack.isEmpty()) {
            Integer val = stack.pop();
            result.add(val);
            if (map.getOrDefault(val, null) != null) {
                result.addAll(map.get(val));
                for (Integer integer : map.get(val)) {
                    stack.push(integer);
                }
            }
        }
        return quchong(result);
    }

    private List<Integer> quchong(List<Integer> reslut) {
        reslut.sort(Comparator.naturalOrder());
        List<Integer> integers = new ArrayList<>();
        for (Integer integer : reslut) {
            if (integers.size() == 0) {
                integers.add(integer);
            } else {
                if (integers.get(integers.size() - 1) != integer) {
                    integers.add(integer);
                }
            }
        }
        return integers;
    }

    private Map<Integer, List<Integer>> transfer(List<Integer> pid, List<Integer> ppid) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (ppid == null || pid == null) {
            return map;
        }
        for (int i = 0; i < ppid.size(); i++) {
            if (map.getOrDefault(ppid.get(i), null) == null) {
                map.put(ppid.get(i), new ArrayList<>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        return map;
    }
}
