// first thought with iterative approach, but have to go through the list every iteration
class Solution {
    public void reorderList(ListNode head) {
        // l1 l2 ... ln1 ln
        ListNode l1 = head, l2 = head.next, ln1 = l1, ln = l2;
        if (l2 == null || l2.next == null) {
            return;
        }
        while (ln.next != null) {
            ln1 = ln1.next;
            ln = ln.next;
        }
        l1.next = ln;
        ln.next = l2;
        ln1.next = null;
        reorderList(l2);
    }
}

