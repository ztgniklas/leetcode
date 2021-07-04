/*
递归法
认为head后面的链表已经完成反转操作，利用head所指结点现在是最后一个节点，从而定位到整个链表的末尾
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode p1=head,p2=head.next;
        ListNode newh = reverseList(p2);
        ListNode p3 = p1.next;
        p3.next = p1;
        p1.next = null;
        return newh;
    }
}

/*
循环
使用三个指针，标记当前指针之前的结点，当前结点，和下一个结点
每次循环，当前节点指向之前节点，三个节点依次后移
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode cur = head,pre=null;
        while(cur!=null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}