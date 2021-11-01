package sort_list;

import common.ListNode;

public class Solution_1 implements Solution {

    @Override
    public ListNode sortList(ListNode head) {
        int n = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;

        while (head != null) {
            head = head.next;
            n++;
        }

        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur.next != null) {
                ListNode left = cur;
                ListNode right = split(cur, step);
                cur = split(right, step);
                prev = merge(left, right, prev);
                // no need link prev with cur,
                // because prev will link to the next sorted sublist in the following iteration
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode cur = prev;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private ListNode split(ListNode head, int step) {
        if (head == null) {
            return null;
        }
        while (step > 1 && head.next != null) {
            head = head.next;
            step--;
        }
        ListNode tmp = head.next;
        head.next = null;
        return tmp;
    }
}
