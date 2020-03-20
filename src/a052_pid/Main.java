package a052_pid;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> pid = Arrays.asList(1, 3, 10, 5);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
        int kill = 5;
        System.out.println(solution.killProcess(pid, ppid, kill).toString());
        System.out.println(solution.killProcess(pid, ppid, 0).toString());
        System.out.println(solution.killProcess(pid, ppid, 1).toString());
        System.out.println(solution.killProcess(pid, ppid, 3).toString());

        pid = Arrays.asList(1, 3, 10, 5, 6, 299, 5000, 6000);
        ppid = Arrays.asList(3, 0, 5, 3, 299, 3, 3, 0);
        kill = 5;

        System.out.println(solution.killProcess(pid, ppid, kill).toString());
        System.out.println(solution.killProcess(pid, ppid, 0).toString());
        System.out.println(solution.killProcess(pid, ppid, 1).toString());
        System.out.println(solution.killProcess(pid, ppid, 3).toString());

        pid = Arrays.asList(1);
        ppid = Arrays.asList(0);
        kill = 1;
        System.out.println(solution.killProcess(pid, ppid, 1).toString());
        System.out.println(solution.killProcess(pid, ppid, 0).toString());

    }
}
