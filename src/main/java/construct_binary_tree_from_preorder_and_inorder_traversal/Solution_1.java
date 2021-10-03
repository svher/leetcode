package construct_binary_tree_from_preorder_and_inorder_traversal;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 implements Solution {

    @Override
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            positionMap.put(inorder[i], i);
        }
        return buildTreeImpl(preorder, 0, 0, inorder.length - 1, positionMap);
    }

    private TreeNode buildTreeImpl(int[] preorder,
                                   int preStart,
                                   int inStart,
                                   int inEnd,
                                   Map<Integer, Integer> positionMap) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        int pivot = preorder[preStart];
        int pivotIdx = positionMap.get(pivot);
        // [中序开始, 枢纽点)
        TreeNode left = buildTreeImpl(preorder, preStart + 1, inStart, pivotIdx - 1, positionMap);
        // (枢纽点, 中序结束]
        TreeNode right = buildTreeImpl(preorder, preStart + pivotIdx - inStart + 1, pivotIdx + 1, inEnd, positionMap);
        return new TreeNode(pivot, left, right);
    }
}