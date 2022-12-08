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
    public ListNode middleNode(ListNode head) {
        ListNode pt = head;
        int len = 0;
        while (pt != null) {
            len++;
            pt = pt.next;
        }
        pt = head;
        for (int i = 0; i < len / 2; i++) {
            pt = pt.next;
        }
        return pt;
    }
}

// 法2：快慢指针，快指针是慢指针速度的两倍，当快指针到结尾时，慢指针一定停在中间。