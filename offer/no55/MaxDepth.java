package offer.no55;

import common.TreeNode;

/**
 * @author Toreno Li
 */
public class MaxDepth {
    private int result = -1;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return result;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        result = Math.max(depth, result);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
