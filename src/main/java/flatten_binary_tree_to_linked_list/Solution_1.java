package flatten_binary_tree_to_linked_list;

import common.TreeNode;

public class Solution_1 implements Solution {

    private TreeNode prev = null;

    @Override
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
