package construct_binary_tree_from_preorder_and_inorder_traversal;

import common.TreeNode;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        TreeNode treeNode = solution.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
    }
}
