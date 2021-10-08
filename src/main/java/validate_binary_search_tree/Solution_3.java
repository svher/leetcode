package validate_binary_search_tree;

import common.TreeNode;

public class Solution_3 implements Solution {

    private TreeNode pre = null;

    @Override
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean res1 = isValidBST(root.left);
        if (pre == null || pre.val >= root.val) {
            return false;
        }
        pre = root;
        boolean res2 = isValidBST(root.right);
        return res1 && res2;
    }
}
