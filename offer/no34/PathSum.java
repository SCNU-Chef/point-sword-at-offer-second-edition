package offer.no34;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Toreno Li
 * 用stream求和,好看但是慢
 * result不能直接添加path,需要重新new一个和path具有相同值的List
 */
public class PathSum {
    private List<List<Integer>> result = new ArrayList<>();
    private Stack<Integer> path = new Stack<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        path.push(root.val);
        if (root.left == null && root.right == null) {
            if (path.stream().mapToInt(i -> i).sum() == target) {
                result.add(new ArrayList<>(path));
            }
        }
        pathSum(root.left, target);
        pathSum(root.right, target);
        path.pop();
        return result;
    }
}
