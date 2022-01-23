package offer.no26;

import common.TreeNode;

/**
 * @author Toreno Li
 * equals:判断两棵树是否具有相同的结构
 * 注意equals中先对B进行判空,再对A进行判空,有讲究的
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (equals(A, B)) {
            return true;
        } else {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    private boolean equals(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && equals(A.left, B.left) && equals(A.right, B.right);
    }
}
