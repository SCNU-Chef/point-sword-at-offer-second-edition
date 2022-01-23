package offer.no18;

import common.ListNode;

/**
 * @author Toreno Li
 * 本题注意边界情况(每次都踩坑)
 * leetcode和书上的题目有差异
 * 书上的删除方式我不是很认可,毕竟节点的地址并没有变,原来的节点还是原来的节点
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode slow = head;
        ListNode quick = slow.next;
        while (quick != null) {
            if (quick.val == val) {
                slow.next = quick.next;
            }
            quick = quick.next;
            slow = slow.next;
        }
        return head;
    }
}
