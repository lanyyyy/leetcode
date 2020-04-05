package learn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试java自带的线程池
 * java.util.concurrent.Executor
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        测试lamda表达式的执行
        new Thread(() -> System.out.println("lamda expression get...")).start();
        new Thread(() -> System.out.println("hello, person")).start();
//        callLamdaTest(() -> System.out.println("use func call lamda"));
        callLamdaTest((int a,int b) -> {
            System.out.println(a+b);
        });
        callLamdaTest((a, b) -> System.out.println(a-b));

        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new Person());
        es.submit(new Person());
        es.submit(new Person());
        es.shutdown();

    }

    static void callLamdaTest(LamdaTest lamdaTest) {
//        lamdaTest.sayHello();
        lamdaTest.cal(1,3);
    }

    static interface LamdaTest {
//        void sayHello();
        void cal(int a, int b);
//        void sayGoogBy();
    }

    static class Person implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--- hello world");
        }
    }
}
