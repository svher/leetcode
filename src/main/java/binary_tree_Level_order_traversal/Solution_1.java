package binary_tree_Level_order_traversal;

import common.TreeNode;

import java.util.*;

class Solution_1 implements Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> levelNodes = new ArrayList<>();
        queue.offer(root);
        int cnt = 1;
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            levelNodes.add(top.val);
            if (top.left != null) {
                queue.offer(top.left);
            }
            if (top.right != null) {
                queue.offer(top.right);
            }
            if (--cnt == 0) {
                ans.add(levelNodes);
                levelNodes = new ArrayList<>();
                cnt = queue.size();
            }
        }
        return ans;
    }
}
