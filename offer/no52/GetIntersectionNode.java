package offer.no52;

import common.ListNode;

/**
 * @author Toreno Li
 * 快慢指针
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode rootA = headA;
        ListNode rootB = headB;
        while (rootA != null) {
            lengthA++;
            rootA = rootA.next;
        }
        while (rootB != null) {
            lengthB++;
            rootB = rootB.next;
        }
        rootA = headA;
        rootB = headB;
        if (lengthA > lengthB) {
            while (lengthA != lengthB) {
                rootA = rootA.next;
                lengthA--;
            }
        } else {
            while (lengthA != lengthB) {
                rootB = rootB.next;
                lengthB--;
            }
        }
        while (rootA != null && rootB != null) {
            if (rootA == rootB) {
                return rootA;
            }
            rootA = rootA.next;
            rootB = rootB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode rootA = headA;
        ListNode rootB = headB;
        while (rootA != rootB) {
            rootA = rootA == null ? headB : rootA.next;
            rootB = rootB == null ? headA : rootB.next;
        }
        return rootA;
    }
}
