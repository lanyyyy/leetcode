package learn.chain;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(7);
        l1.next.next.next.next = new ListNode(9);

        ListNode head = l1;

        System.out.println("翻转前：");
        while (l1 != null) {
            System.out.print(l1.val + " -> ");
            l1 = l1.next;
        }

        ListNode l2 = head;
        Stack<ListNode> stack = new Stack<>();
        while (l2 != null) {
            stack.push(l2);
            l2 = l2.next;
        }
        ListNode result = stack.pop();
        ListNode reverse = result;
        while (!stack.isEmpty()) {
            result.next = stack.pop();
            result = result.next;
        }
        result.next = null;

        System.out.println("翻转后：");
        while (reverse != null) {
            System.out.print(reverse.val + " -> ");
            reverse = reverse.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
