package a002_two_add;

/**
 * 测试一下链表的特性
 */
public class Main {
    public static void main(String[] args) {
        // 1. 测试一下head的next从null变为一个obj的时候，会不会有异常
        Node result = null;
        Node head = new Node(10);
        head.next = result;
        result = new Node(11);
        System.out.println(head.val);
        // result重新生成后，相应的值也会发生变化，next就找不到了，因为实例的地址变了
//        System.out.println(head.next.val);
        System.out.println(result.val);

        // 2. 测试一下指向同一个地址的时候，是否会发生变化？
        Node result1 = new Node(20);
        Node head1 = result1;
        result1 = result1.next;
        System.out.println(head1.val);
        System.out.println(result1);

    }

    public static class Node{
        int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
