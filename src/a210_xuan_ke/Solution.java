package a210_xuan_ke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private boolean isFind = false;
    private boolean isLoop = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> maps = getMap(numCourses, prerequisites);
        boolean[] status = new boolean[numCourses];
        List<Integer> store = new ArrayList<>();
        isFind = false;
        isLoop = false;
        if (search(maps, 0, status, store)) {
            int[] results = new int[store.size()];
            int total = store.size() - 1;
            while (total >= 0) {
                results[total] = store.remove(store.size() - 1);
                total--;
            }
            return results;
        } else {
            return new int[0];
        }

    }

    private boolean search(Map<Integer, List<Integer>> maps, int index, boolean[] status, List<Integer> store) {
        if (isFind) {
            return true;
        } else if (isLoop) {
            return false;
        }
        for (int i = index; i < maps.size(); i++) {
            if (isFind) {
                return true;
            }
            status[i] = true;
            store.add(i);
            List<Integer> integers = maps.get(i);

            if (integers.size() == 0) {
                isFind = checkIfIsFind(status);
                if (isFind) {
                    return true;
                }
            } else {
                if (checkIfIsFind(maps, status, integers)) {
                    isFind = true;
                    return true;
                }
                if (checkIfIsLoop(maps, status, integers)) {
                    // 子map不为空，且都已扫描过，则存在循环
                    isLoop = false;
                } else {
                    for (Integer integer : integers) {
                        if (!status[integer]) {
                            if (!search(maps, integer, status, store)) {
                                status[i] = false;
                                store.remove(i);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean checkIfIsLoop(Map<Integer, List<Integer>> maps, boolean[] status, List<Integer> integers) {
        boolean st = true;
        for (Integer integer : integers) {
            st = st && status[integer] && maps.get(integer).size() != 0;
        }
        return st;
    }

    private boolean checkIfIsFind(Map<Integer, List<Integer>> maps, boolean[] status, List<Integer> integers) {
        boolean st = true;
        for (Integer integer : integers) {
            st = st && status[integer] && maps.get(integer).size() == 0;
        }
        for (boolean b: status) {
            if (!b) {
                return b;
            }
        }
        return st;
    }

    private boolean checkIfIsFind(boolean[] status) {
        for (boolean b : status) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> getMap(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> maps = new HashMap<>(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            if (maps.getOrDefault(prerequisites[i][0], null) == null) {
                maps.put(prerequisites[i][0], new ArrayList<>());
            }
            maps.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (maps.getOrDefault(i, null) == null) {
                maps.put(i, new ArrayList<>());
            }
        }

        return maps;
    }
}