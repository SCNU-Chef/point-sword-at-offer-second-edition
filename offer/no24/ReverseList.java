package offer.no24;

import common.ListNode;

/**
 * @author Toreno Li
 * 没啥好写的
 * 原地反转!
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null||head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
