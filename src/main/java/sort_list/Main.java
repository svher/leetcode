package sort_list;

import common.ListNode;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        ListNode node = new ListNode(4);
        ListNode head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(3);
        solution.sortList(head);
    }
}
