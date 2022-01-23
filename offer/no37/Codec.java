package offer.no37;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Toreno Li
 * 若序列化结果不为"null",则其开头是分隔符','
 * 故index的初始值为1
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return "null";
        }
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head == null) {
                stringBuilder.append(",null");
            } else {
                stringBuilder.append(",").append(head.val);
                queue.add(head.left);
                queue.add(head.right);
            }
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] val = data.split(",");
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode result = new TreeNode(Integer.parseInt(val[index++]));
        queue.add(result);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (!val[index].equals("null")) {
                poll.left = new TreeNode(Integer.parseInt(val[index]));
                queue.add(poll.left);
            }
            index++;
            if (!val[index].equals("null")) {
                poll.right = new TreeNode(Integer.parseInt(val[index]));
                queue.add(poll.right);
            }
            index++;
        }
        return result;
    }
}