package a002_two_add;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        solution.printList(solution.addTwoNumbers(l1, l2));

    }

    private void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinWei = 0;
        ListNode result = new ListNode(0);
        ListNode head = result;
//        head.next = result;
        while (l1 != null && l2 != null) {
            int total = l1.val + l2.val + jinWei;
            if (total >= 10) {
                jinWei = 1;
            } else {
                jinWei = 0;
            }
            result.val = total % 10;

            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null || l2 != null) {
                result.next = new ListNode(-111);
                result = result.next;
            }
        }
        if (l1 != null) {
            jinWei = getListNode(l1, jinWei, result);
        } else if (l2 != null) {
            jinWei = getListNode(l2, jinWei, result);
        }
        if (jinWei == 1) {
            result.next = new ListNode(jinWei);
        }
        return head;

    }

    private int getListNode(ListNode l1, int jinWei, ListNode result) {
        while (l1 != null) {
            int total = l1.val + jinWei;
            if (total >= 10) {
                jinWei = 1;
            } else {
                jinWei = 0;
            }
            result.val = total % 10;
            l1 = l1.next;
            // 如果还有，则继续生成result
            if (l1 != null) {
                result.next = new ListNode(-111);
                result = result.next;
            }
        }
        if (jinWei == 1) {
            result.next = new ListNode(jinWei);
            jinWei = 0;
        }
        return jinWei;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
