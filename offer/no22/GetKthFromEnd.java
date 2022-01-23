package offer.no22;

import common.ListNode;

/**
 * @author Toreno Li
 * 没啥好说的,快慢指针
 * 书上要考虑输入的合理性,链表是否为空,k的取值等等
 * leetcode则保证了输入的合理性
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode quick = head;
        ListNode slow = head;
        while (k != 0) {
            quick = quick.next;
            k--;
        }
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }
}
