package offer.no36;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Toreno Li
 * 1.用list存储中序遍历时的node,遍历完成后直接在list中操作node
 * 2.不借助list,原地转换
 */
public class TreeToDoublyList {
    private List<Node> list = new ArrayList<>();

    public Node treeToDoublyList1(Node root) {
        if (root == null) {
            return null;
        }
        dfs1(root);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).left = list.get((i - 1 + size) % size);
            list.get(i).right = list.get((i + 1) % size);
        }
        return list.get(0);
    }

    private void dfs1(Node root) {
        if (root == null) {
            return;
        }
        dfs1(root.left);
        list.add(root);
        dfs1(root.right);
    }

    private Node pre;
    private Node head;

    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return null;
        }
        dfs2(root);
        //经历完遍历后,pre指向双向链表最大的节点(尾节点),head指向最小的节点(头节点)
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs2(Node cur) {
        if (cur == null) {
            return;
        }
        dfs2(cur.left);
        if (pre == null) {
            //此时cur为双向链表中的头节点,是最小的值
            head = cur;
        } else {
            pre.right = cur;
        }
        //pre是否为空不影响cur.left的赋值
        cur.left = pre;
        pre = cur;
        dfs2(cur.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};