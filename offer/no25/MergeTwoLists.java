package offer.no25;

import common.ListNode;

/**
 * @author Toreno Li
 * 合理利用伪头节点,能写出简洁的代码
 * 还可以递归解答,但是慢
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (val1 > val2) {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            } else {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
        }
        return result.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            } else {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
        }
        head.next = l1 == null ? l2 : l1;
        return result.next;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val > l2.val) {
            head = l2;
            head.next = mergeTwoLists3(l1, l2.next);
        } else {
            head = l1;
            head.next = mergeTwoLists3(l1.next, l2);
        }
        return head;
    }
}
