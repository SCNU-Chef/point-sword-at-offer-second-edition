package offer.no35;

/**
 * @author Toreno Li
 * 1.复制的节点紧挨被复制的
 * 2.赋值random
 * 3.断链
 * 两连跳的时候应该考虑null的情况,不能直接跳两步
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node res = head.next;
        cur = res;
        Node pre = head;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = cur.next == null ? null : cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        return res;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}