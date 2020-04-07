package a023_merge_k_chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 场景：
 * 1. 使用List维护头部排序，Comparator排序，时间：550ms
 * 2. 使用List维护头部排序，选择排序，时间：13ms
 * 3. 使用PriorityQueue维护头部排序，时间：5ms ---》 时间简单
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] listNodes = {l1, l2, l3};

        new Solution().mergeKLists(listNodes);

    }

    /**
     * 将list的所有头部维护起成一个list，进行测试排序输出
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;

        if (lists == null || lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        List<ListNode> listNodes = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                listNodes.add(lists[i]);
            }
        }
        listNodes.sort((o1, o2) -> o1.val - o2.val);
        while (listNodes.size() > 1) {
            cur.next = listNodes.get(0);
            cur = cur.next;
            if (listNodes.get(0).next != null) {
                listNodes.set(0, listNodes.get(0).next);
            } else {
                listNodes.remove(0);
            }
            // 这块可以优化为选择排序: 注意：这块使用选择排序后，力扣用例时间时间直接从550ms -> 13ms
//            listNodes.sort((o1, o2) -> o1.val - o2.val);
            selectSort(listNodes);
        }
        if (listNodes.size() == 1) {
            cur.next = listNodes.get(0);
        }
        return dummyNode.next;
    }

    private void selectSort(List<ListNode> listNodes) {
        ListNode start = listNodes.get(0);
        int index = 1;
        while (index < listNodes.size()) {
            if (start.val > listNodes.get(index).val) {
                listNodes.set(index - 1, listNodes.get(index));
                index++;
            } else {
                break;
            }
        }
        listNodes.set(index - 1, start);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
