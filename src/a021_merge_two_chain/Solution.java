package a021_merge_two_chain;


import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(5);

        ListNode head = new Solution().mergeTwoLists(l1, l2);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val >= l2.val) {
                    cur.next = l2;
                    l2 = l2.next;
                } else {
                    cur.next = l1;
                    l1 = l1.next;
                }
            } else if (l1 == null) {
                cur.next = l2;
                break;
                // 这里可以直接终止了，没必要再遍历了；
//                l2 = l2.next;
            } else if (l2 == null) {
                cur.next = l1;
                break;
                // 这里可以直接终止了，没必要再遍历了；
//                l1 = l1.next;
            }
            cur = cur.next;
        }
        return head.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
