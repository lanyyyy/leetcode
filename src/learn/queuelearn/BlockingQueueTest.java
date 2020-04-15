package learn.queuelearn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();
        linkedBlockingDeque.poll();

        new Thread(() -> {
            try {
                Thread.sleep(5 * 1000);
                linkedBlockingDeque.add("haha");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("测试阻塞");
        linkedBlockingDeque.take();
        System.out.println("over...");


        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(100);
//        arrayBlockingQueue.take();// 会阻塞
        arrayBlockingQueue.poll();
        System.out.println("array over...");
    }


}
