package offer.no28;

import common.TreeNode;

/**
 * @author Toreno Li
 * 我第一眼的思路是先镜像,再比较树是否相等(受到前两题的影响了)
 * 但是这种做法需要额外的空间开销,而且比较麻烦
 * 不如递归,定义一种新的遍历方式:反前序遍历
 * 利用前序遍历(根左右)和反前序遍历(根右左)进行比较
 * 即可判定树是不是对称的
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}
