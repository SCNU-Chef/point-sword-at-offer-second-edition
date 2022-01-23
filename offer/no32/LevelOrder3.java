package offer.no32;

import common.TreeNode;

import java.util.*;

/**
 * @author Toreno Li
 * 加一个方向参数,每次存储完成一行,就改变方向
 * 在存储时根据方向判断是否需要翻转curLevel
 */
public class LevelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean directIsLeft = false;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode polled = queue.poll();
                curLevel.add(polled.val);
                if (polled.left != null) {
                    queue.add(polled.left);
                }
                if (polled.right != null) {
                    queue.add(polled.right);
                }
            }
            if (directIsLeft) {
                Collections.reverse(curLevel);
            }
            result.add(curLevel);
            directIsLeft = !directIsLeft;
        }
        return result;
    }
}
