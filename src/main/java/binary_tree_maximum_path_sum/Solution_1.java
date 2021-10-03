package binary_tree_maximum_path_sum;

import common.TreeNode;

public class Solution_1 implements Solution {

    private int maxPath;

    @Override
    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        getMaxGain(root);
        return maxPath;
    }

    private int getMaxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = getMaxGain(root.left);
        int rightGain = getMaxGain(root.right);
        maxPath = Math.max(maxPath, leftGain + rightGain + root.val);

        // if the gain is less than 0, we simply ignore it.
        return Math.max(0, Math.max(leftGain, rightGain) + root.val);
    }
}
