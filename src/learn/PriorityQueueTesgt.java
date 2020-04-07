package learn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTesgt {
    public static void main(String[] args) {
        // 先试用默认的排序
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(10);
        queue.add(-1);
        queue.add(-10);
        queue.add(100);
        queue.add(-50);
        queue.add(4);
        queue.add(9);
        queue.add(0);
        System.out.println("默认排序：");
        printQ(queue);

        System.out.println("\n修改排序");
        PriorityQueue<Integer> queue1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue1.add(1);
        queue1.add(10);
        queue1.add(-1);
        queue1.add(-10);
        queue1.add(100);
        queue1.add(-50);
        queue1.add(4);
        queue1.add(9);
        queue1.add(0);
        printQ(queue1   );



    }

    private static void printQ(PriorityQueue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " -> ");
        }
    }
}
