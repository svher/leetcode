package binary_tree_right_side_view;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution_1 implements Solution {

    @Override
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightSideViewImpl(root, ans, 0);
        return ans;
    }

    private void rightSideViewImpl(TreeNode root, List<Integer> ans, int depth) {
        if (root == null) {
            return;
        }
        if (ans.size() == depth) {
            ans.add(root.val);
        }
        rightSideViewImpl(root.right, ans, depth + 1);
        rightSideViewImpl(root.left, ans, depth + 1);
    }
}
