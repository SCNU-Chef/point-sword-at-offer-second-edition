package offer.no33;

import java.util.Arrays;

/**
 * @author Toreno Li
 * 第一个循环中让mid能取到最后一位,即没有右子树的情况
 * 递归:优雅永不过时
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) {
            return true;
        }
        int mid = 0;
        int lastVal = postorder[postorder.length - 1];
        while (postorder[mid] < lastVal) {
            mid++;
        }
        for (int i = mid; i < postorder.length - 1; i++) {
            if (postorder[i] < lastVal) {
                return false;
            }
        }
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, mid)) &&
                verifyPostorder(Arrays.copyOfRange(postorder, mid, postorder.length - 1));
    }
}
