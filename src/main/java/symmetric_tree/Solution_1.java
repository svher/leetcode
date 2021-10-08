package symmetric_tree;

import common.TreeNode;

import java.util.Stack;

public class Solution_1 implements Solution {

    @Override
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root.left);
        stack.add(root.right);
        while (!stack.empty()) {
            TreeNode l1 = stack.pop();
            TreeNode l2 = stack.pop();
            if (l1 == null && l2 == null) {
                continue;
            }
            if (l1 == null || l2 == null || l1.val != l2.val) {
                return false;
            }
            stack.push(l1.left);
            stack.push(l2.right);
            stack.push(l1.right);
            stack.push(l2.left);
        }
        return true;
    }
}
