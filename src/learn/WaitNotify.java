package learn;


public class WaitNotify {

    private static int apple = 30;
    private static int limit = 50;
    private static final Object object = new Object();

    public static void main(String[] args) {
        Customer customer = new Customer();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Market market = new Market();
        Market market1 = new Market();
        new Thread(customer).start();
        new Thread(customer1).start();
        new Thread(customer2).start();
        new Thread(market).start();
        new Thread(market1).start();
    }

    static class Customer implements Runnable {
        void buyApple() {
            while (true) {
                synchronized (object) {
                    if (apple <= 0) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Buy Apple ......, left " + --apple);
                        object.notifyAll();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        public void run() {
            buyApple();
        }
    }

    static class Market implements Runnable {
        void putApple() {
            while (true) {
                synchronized (object) {
                    if (apple >= 50) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("put Apple ......, Now " + ++apple);
                        object.notifyAll();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            putApple();
        }
    }
}
