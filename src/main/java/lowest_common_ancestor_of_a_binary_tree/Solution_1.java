package lowest_common_ancestor_of_a_binary_tree;

import common.TreeNode;

public class Solution_1 implements Solution {

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // IMPORTANT NOTE HERE: we assume both key are existed in the tree,
        // if one key is missing, we simply return another key as LCA rather than null
        // if we want to ensure both key are existed, we need to store the flag about which key are visited
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }
}
