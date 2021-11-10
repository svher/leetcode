package serialize_and_deserialize_binary_tree;

import common.TreeNode;

public interface Codec {
    // Encodes a tree to a single string.
    String serialize(TreeNode root);

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data);
}
