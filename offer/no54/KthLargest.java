package offer.no54;

import common.TreeNode;

/**
 * @author Toreno Li
 * 左根右是升序,右根左是降序
 */
public class KthLargest {
    private int step = 0;
    private int result = 0;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.right, k);
        step++;
        if (step == k) {
            result = root.val;
        }
        dfs(root.left, k);
    }
}
