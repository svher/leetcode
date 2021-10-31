package kth_smallest_element_in_a_bst;

import common.TreeNode;

public class Solution_1 implements Solution {

    int k;
    int ans;

    @Override
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        kthSmallestImpl(root);
        return ans;
    }

    private void kthSmallestImpl(TreeNode root) {
        if (root == null) {
            return;
        }
        kthSmallestImpl(root.left);
        if (--k == 0) {
            ans = root.val;
            return;
        }
        kthSmallestImpl(root.right);
    }
}
