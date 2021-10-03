package merge_k_sorted_lists;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1 implements Solution {

    @Override
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.offer(list);
            }
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) {
                priorityQueue.offer(node.next);
            }
        }
        return head.next;
    }
}
