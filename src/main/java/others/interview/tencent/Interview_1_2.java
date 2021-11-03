package others.interview.tencent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interview_1_2 {

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        solution_1.testDuplicate();
        System.out.println("#############");
        Solution_2 solution_2 = new Solution_2();
        solution_2.testRestore();
        System.out.println("#############");
        Solution_3 solution_3 = new Solution_3();
        solution_3.testCalc();
    }

    static class Solution_1 {

        class LinkNode {
            LinkNode next;
            int value;

            public LinkNode(int val) {
                this.value = val;
            }
        }

        public void testDuplicate() {
            //  1->1->2->3->3->4->null
            LinkNode head = new LinkNode(1);
            LinkNode node = head;
            node.next = new LinkNode(1);
            node = node.next;
            node.next = new LinkNode(1);
            node = node.next;
            node.next = new LinkNode(2);
            node = node.next;
            node.next = new LinkNode(3);
            node = node.next;
            node.next = new LinkNode(3);
            node = node.next;
            node.next = new LinkNode(4);
            LinkNode res = delete_duplicates(head);
            while (res.next != null) {
                System.out.printf("%d -> ", res.value);
                res = res.next;
            }
            System.out.println(res.value);
        }

        LinkNode delete_duplicates(LinkNode head) {
            LinkNode dummy = new LinkNode(0);
            dummy.next = head;
            LinkNode cur = dummy;
            while (cur.next != null) {
                LinkNode prev = cur;
                int val = cur.next.value;
                boolean flag = false;
                cur = cur.next;
                while (cur.next != null && cur.next.value == val) {
                    flag = true;
                    cur = cur.next;
                }
                if (flag) {
                    prev.next = cur.next;
                }
            }
            return dummy.next;
        }
    }

    static class Solution_2 {

        public void testRestore() {
            System.out.println(restoreIpAddrs("25525511135"));
        }

        private void restoreIpAddrsImpl(List<String> ans, String input, String s, int k, int index) {
            if (k == 4) {
                if (index == input.length()) {
                    ans.add(s.substring(1));
                }
                return;
            }
            if (index + 1 <= input.length()) {
                restoreIpAddrsImpl(ans, input, s + "." + input.charAt(index), k + 1, index + 1);
            }
            if (index + 2 <= input.length()) {
                restoreIpAddrsImpl(ans, input, s + "." + input.substring(index, index + 2), k + 1, index + 2);
            }
            if (index + 3 <= input.length()) {
                String seg = input.substring(index, index + 3);
                if (Integer.parseInt(seg) <= 255) {
                    restoreIpAddrsImpl(ans, input, s + "." + seg, k + 1, index + 3);
                }
            }
        }

        private List<String> restoreIpAddrs(String s) {
            List<String> ans = new ArrayList<>();
            restoreIpAddrsImpl(ans, s, "",0, 0);
            return ans;
        }
    }

    static class Solution_3 {

        public void testCalc() {
            System.out.println(calc(1, 3));
            System.out.println(calc(7, 22));
            System.out.println(calc(62, 45));
            System.out.println(calc(5, 42));
            System.out.println(calc(1, 2));
        }

        String calc(int a, int b) {
            int integer = a / b;
            Map<Integer, Integer> map = new HashMap<>();
            boolean positive = true;
            int index = 0;
            if (a < 0) {
                a = Math.abs(a);
                positive = false;
            }
            int mod = a % b;
            StringBuilder sb = new StringBuilder();
            while (mod != 0 && !map.containsKey(mod)) {
                map.put(mod, index);
                while (mod * 10 < b) {
                    mod *= 10;
                    sb.append("0");
                    index++;
                }
                mod *= 10;
                sb.append(mod / b);
                index++;
                mod = mod % b;
            }
            if (map.containsKey(mod)) {
                sb.insert(map.get(mod), "(");
                sb.append(")");
            }
            String ans = Integer.toString(integer);
            if (sb.length() != 0) {
                ans += "." + sb;
            }
            if (!positive && integer == 0) {
                ans = "-" + ans;
            }
            return ans;
        }
    }
}