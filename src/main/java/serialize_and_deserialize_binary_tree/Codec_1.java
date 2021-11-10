package serialize_and_deserialize_binary_tree;

import common.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Codec_1 implements Codec {

    // Encodes a tree to a single string.
    @Override
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeImpl(sb, root);
        return sb.toString();
    }

    private void serializeImpl(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append("#").append(",");
        } else {
            sb.append(root.val).append(",");
            serializeImpl(sb, root.left);
            serializeImpl(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    @Override
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeImpl(nodes);
    }

    private TreeNode deserializeImpl(Deque<String> data) {
        String val = data.remove();
        if (Objects.equals(val, "#")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = deserializeImpl(data);
            node.right = deserializeImpl(data);
            return node;
        }
    }
}
