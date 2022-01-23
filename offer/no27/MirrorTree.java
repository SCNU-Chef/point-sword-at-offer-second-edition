package offer.no27;

import common.TreeNode;

/**
 * @author Toreno Li
 * 一眼黄油
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
