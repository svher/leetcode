package reverse_nodes_in_k_group;

import common.ListNode;

public class Solution_1 implements Solution {

    @Override
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode boundary = head;
        int cnt = k;
        while (cnt > 0 && boundary != null) {
            boundary = boundary.next;
            cnt--;
        }
        if (cnt > 0) {
            return head;
        } else {
            ListNode cur = head.next, prev = head;
            head.next = reverseKGroup(boundary, k);
            while (cur != boundary) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            head = prev;
        }
        return head;
    }
}
