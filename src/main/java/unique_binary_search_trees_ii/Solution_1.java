package unique_binary_search_trees_ii;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_1 implements Solution {

    @Override
    public List<TreeNode> generateTrees(int n) {
        return generateTreesImpl(1, n);
    }

    private List<TreeNode> generateTreesImpl(int start, int end) {
        if (start > end) {
            return Collections.singletonList(null);
        }
        if (start == end) {
            return Collections.singletonList(new TreeNode(start));
        }
        List<TreeNode> ansList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTreesImpl(start, i - 1);
            List<TreeNode> rightList = generateTreesImpl(i + 1, end);
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    ansList.add(root);
                }
            }
        }
        return ansList;
    }
}
