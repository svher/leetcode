package convert_sorted_array_to_binary_search_tree;

import common.TreeNode;

public class Solution_1 implements Solution {

    @Override
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTImpl(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTImpl(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = (l + r) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = sortedArrayToBSTImpl(nums, l, m - 1);
        node.right = sortedArrayToBSTImpl(nums, m + 1, r);
        return node;
    }
}
