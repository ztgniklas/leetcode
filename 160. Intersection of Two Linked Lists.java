/*
hashtable，先记录一个list。然后遍历第二个list，取第一个存在于set的节点
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hs = new HashSet<>();
        ListNode na = headA,nb=headB;
        while(na!=null){
            hs.add(na);
            na = na.next;
        }
        while(nb!=null){
            if(hs.contains(nb))
                return nb;
            else{
                nb = nb.next;
            }
        }
        return null;
    }
}

/*
这个方法通过让指向A和B的指针两个list都走一遍来拉平两个list的长度差距，比如[1,3,5,7,9,11]和[2,4,9,11]在9相交，我们让两边的指针每个list都走一遍，即[1,3,5,7,9,11,2,4,9,11]和[2,4,9,11,1,3,5,7,9,11]。两个指针必在相交结点相遇且是第一次相遇。
对于不相交的两个list，由于指针也是两个list都走一遍，所以同时在各自路程的末尾相遇，都是null，也符合题意。
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode na=headA,nb=headB;
        while(na!=nb){
            na=(na==null)?headB:na.next;
            nb=(nb==null)?headA:nb.next;
        }
        return na;
    }
}

/*
对于这种求两组数据共有部分的题，可以考虑map思想，也可以考虑双指针，并且拉平两者的长度
*/