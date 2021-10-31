package linked_list_cycle_ii;

import common.ListNode;

public class Solution_1 implements Solution {

    @Override
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next, fast = head.next.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode res = head;
        // 2 * (l + m) = l + m + nC
        // l = nC - m
        // so res move l, slow move nC - m, they'll meet at the entry position
        while (res != slow) {
            res = res.next;
            slow = slow.next;
        }
        return res;
    }
}
