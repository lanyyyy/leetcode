package a019_delete_n_node;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        new Solution().removeNthFromEnd(head, 1);
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        Map<Integer, ListNode> map = new HashMap<>();
        int start = 1;
        ListNode cur = head;
        while (cur != null) {
            map.putIfAbsent(start++, cur);
            cur = cur.next;
        }
        if (n == 1) {
            if (start == 2) {
                return null;
            }
            map.get(start - 2).next = null;
        } else if ( n == start - 1) {
            return head.next;
        } else {
            int label = start - n;
            map.get(label - 1).next = map.get(label + 1);
        }
        return head;
    }

     public static class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
         }
     }
}
