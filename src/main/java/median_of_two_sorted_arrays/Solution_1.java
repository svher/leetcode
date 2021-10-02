package median_of_two_sorted_arrays;

public class Solution_1 implements Solution {

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int l = 0, r = nums1.length - 1;
        int total = nums1.length + nums2.length;
        int half = total / 2;

        while (true) {
            // 这里 m1 和 Solution 2 不同的是指向的是分区的末尾，而不是末尾后的下一个元素
            int m1 = Math.floorDiv(l + r, 2);
            int m2 = half - m1 - 2;

            int lvalue1 = m1 >= 0 ? nums1[m1] : (Integer.MIN_VALUE + 1);
            int rvalue1 = (m1 + 1) < nums1.length ? nums1[m1 + 1] : Integer.MAX_VALUE;

            int lvalue2 = m2 >= 0 ? nums2[m2] : (Integer.MIN_VALUE + 1);
            int rvalue2 = (m2 + 1) < nums2.length ? nums2[m2 + 1] : Integer.MAX_VALUE;

            if (lvalue1 <= rvalue2 && lvalue2 <= rvalue1) {
                if (total % 2 == 0) {
                    return (Math.max(lvalue1, lvalue2) + Math.min(rvalue1, rvalue2)) / 2f;
                } else {
                    return Math.min(rvalue1, rvalue2);
                }
            } else if (lvalue1 > rvalue2) {
                r = m1 - 1;
            } else {
                l = m1 + 1;
            }
        }
    }
}
