/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftLeft = null, betHead = null, betTail = null, rightRight = null;
        int n = 0;
        ListNode pt = head;
        while (pt != null) {
            n++;
            pt = pt.next;
        }
        pt = head;
        for (int i = 1; i <= n; i++) {
            if (i == left - 1) {
                leftLeft = pt;
            } else if (i == left) {
                betHead = pt;
            }
            if (i == right) {
                betTail = pt;
            } else if (i == right + 1) {
                rightRight = pt;
            }
            pt = pt.next;
        }
        
        if (left == 1) {
            leftLeft = null;
        }
        
        if (right == n) {
            rightRight = null;
        }
        
        betTail.next = null;
        reverseList(betHead);
        if (leftLeft != null) {
            leftLeft.next = betTail;
        }
        betHead.next = rightRight;
        if (leftLeft == null) {
            return betTail;
        }
        return head;
    }
    
    private void reverseList(ListNode head) {
        ListNode pt1 = null, pt2 = head;
        while (pt2 != null) {
            ListNode pt3 = pt2;
            pt2 = pt2.next;
            pt3.next = pt1;
            pt1 = pt3;
        }
    }
}