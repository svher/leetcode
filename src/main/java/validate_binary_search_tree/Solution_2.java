package validate_binary_search_tree;

import common.TreeNode;

public class Solution_2 implements Solution {

    @Override
    public boolean isValidBST(TreeNode root) {
        return isValidBSTImpl(root, null, null);
    }

    private boolean isValidBSTImpl(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) {
            return true;
        }
        if ((minNode != null && minNode.val >= root.val) || (maxNode != null && maxNode.val <= root.val)) {
            return false;
        }
        return isValidBSTImpl(root.left, minNode, root) && isValidBSTImpl(root.right, root, maxNode);
    }
}
