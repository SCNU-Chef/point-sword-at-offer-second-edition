package offer.no32;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Toreno Li
 * 最后一句虽然好看,但是慢
 */
public class LevelOrder1 {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
            }
            list.add(queue.peek().val);
            queue.poll();
        }
        return list.stream().mapToInt(i -> i.intValue()).toArray();
    }
}
