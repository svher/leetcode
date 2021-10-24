package count_complete_tree_nodes;

import common.TreeNode;

public class Solution_1 implements Solution {

    @Override
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = 0, hr = 0;
        TreeNode l = root, r = root;
        while (l != null) {
            hl++;
            l = l.left;
        }
        while (r != null) {
            hr++;
            r = r.right;
        }
        if (hl == hr) {
            // 2 ^ (h + 1) - 2 + 1
            // hl = h + 1
            return (1 << hl) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}