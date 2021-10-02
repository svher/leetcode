package median_of_two_sorted_arrays;

public class Solution_2 implements Solution {

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        if (nums2.length == 0) {
            return 0;
        }

        int m = nums1.length, n = nums2.length;
        int half = (m + n) / 2;

        int l = 0, r = m;
        while (true) {
            int m1 = (l + r) / 2;
            int m2 = half - m1;

            if ((m1 == m || m2 == 0 || nums2[m2 - 1] <= nums1[m1])
                && (m1 == 0 || m2 == n || nums1[m1 - 1] <= nums2[m2])) {
                int maxL, minR;
                if (m1 == m) {
                    minR = nums2[m2];
                } else if (m2 == n) {
                    minR = nums1[m1];
                } else {
                    minR = Math.min(nums1[m1], nums2[m2]);
                }

                if ((m + n) % 2 == 1) {
                    return minR;
                }

                if (m1 == 0) {
                    maxL = nums2[m2 - 1];
                } else if (m2 == 0) {
                    maxL = nums1[m1 - 1];
                } else {
                    maxL = Math.max(nums1[m1 - 1], nums2[m2 - 1]);
                }

                return (maxL + minR) / 2f;
            } else if (m1 > 0 && nums1[m1 - 1] > nums2[m2]) {
                /*
                Note: m1 > 0 -> m2 < n
                Because: m2 = (m + n) / 2 - m1 < (m + n) / 2 < 2n / 2 = n
                 */
                r = m1 - 1;
            } else {
                l = m1 + 1;
            }
        }
    }
}
