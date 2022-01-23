package offer.no68;

import common.TreeNode;

/**
 * @author Toreno Li
 * 普通二叉树,值可以不唯一
 * 终于刷完了
 */
public class LowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            // 遍历到空了,或者找到了
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) {
            // 左子树中未找到两个节点,表示都在右子树中
            return right;
        }
        if (right == null) {
            return left;
        }
        // 不可能left和right都为空
        return root;
    }
}
