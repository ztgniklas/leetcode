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
    ListNode nextStart;
    ListNode lastTail = null;

    public ListNode sortList(ListNode head) {
        int len = getLen(head);
        ListNode start = head;
        for (int size = 1; size < len; size *= 2) {
            boolean flag = true;
            ListNode nextSizeHead = new ListNode();
            lastTail = null;
            while (start != null) {
                ListNode mid = getMid(start, size);
                ListNode curHead = merge(start, mid);
                if (flag) {
                    nextSizeHead = curHead;
                    flag = false;
                }
                start = nextStart;
            }
            start = nextSizeHead;

        }
        return start;
    }

    private int getLen(ListNode head) {
        int len = 0;
        ListNode pt = head;
        while (pt != null) {
            len++;
            pt = pt.next;
        }
        return len;
    }

    private ListNode getMid(ListNode start, int size) {
        ListNode mid = start, end = new ListNode();
        for (int i = 0; i < size; i++) {
            if (mid == null) {
                break;
            }
            end = mid;
            mid = mid.next;
        }
        if (end != null) {
            end.next = null;
        }
        nextStart = mid;
        for (int i = 0; i < size; i++) {
            if (nextStart == null) {
                break;
            }
            end = nextStart;
            nextStart = nextStart.next;
        }
        if (end != null) {
            end.next = null;
        }

        return mid;
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode pt = new ListNode(), dummyHead = pt, pt1 = n1, pt2 = n2;
        while (pt1 != null && pt2 != null) {
            if (pt1.val < pt2.val) {
                pt.next = pt1;
                pt1 = pt1.next;
            } else {
                pt.next = pt2;
                pt2 = pt2.next;
            }
            pt = pt.next;
        }

        while (pt1 != null) {
            pt.next = pt1;
            pt = pt.next;
            pt1 = pt1.next;
        }

        while (pt2 != null) {
            pt.next = pt2;
            pt = pt.next;
            pt2 = pt2.next;
        }
        if (lastTail != null) {
            lastTail.next = dummyHead.next;
        }
        lastTail = pt;
        return dummyHead.next;
    }
}