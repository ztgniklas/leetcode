/*
这里不能写al.get(i)!=al.get(al.size()-i-1)
因为al存储的类型是int的包装类Integer，==和!=是在比较两个Integer对象是否相同，即进行的是地址比较，应该使用intValue()取其数值或使用equals方法进行数值比较。

这里就涉及到Java的对象池机制。为了防止频繁删除创建对象增加系统开销，Java的Integer类实现了对象池IntegerCache，预先缓存了数值从-128到127的256个Integer对象。
使用Integer i1 = number;//实际会调用valueOf
或者Integer i1 = Integer.valueOf(number);
只要-128<=number<=127，那么实际上并没有新创建对象，i1实际指向了IntegerCache中已经存在的数值为number的对象。
只有Integer i1 = new Integer(number);才是真的新建了一个Integer对象

回到本题。如果直接使用!=判断，当样例是[-129,-129]时，正确的输出显然是true，但程序会输出false。这就是因为-129<-128，所以list中加入的两个Integer对象虽然数值相同，但属于不同对象，自然认为!=是成立的，从而输出false。

总结：==和!=是判断对象是否指向同一地址的，如果要进行内容比较，应该使用类提供的equals方法或其他比较方法。
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        List<Integer> al = new ArrayList<>();
        while(head!=null){
            al.add(head.val);
            head = head.next;
        }
        for(int i=0;i<al.size()/2;i++){
            if(al.get(i).intValue() != al.get(al.size()-i-1).intValue())
                return false;
        }
        return true;
    }
}

/*
O(n) time and O(1) space的算法，使用链表反转
使用快慢指针，快指针一次向后移动两个节点，慢指针一次一个。这样当快指针移动到最后一个节点（链表共奇数个节点）或最后一个结点指向的null（偶数个节点）时，慢指针正好移动到中间。
快指针的作用是帮助慢指针定位。慢指针本身用来反转前一半链表，具体方法与206题的循环法相同。
最后prev指针指向前一半已反转链表表头，慢指针指向后一半表头，同时移动查看数值即可
例如：1->2->2->1 变成
1<-2      2->1
   |      |
  prev   slow
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode slow=head,fast=head,prev=null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            ListNode nxt = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nxt;
        }
        if(fast!=null)//there is odd number of nodes
            slow = slow.next;
        while(prev!=null){
            if(slow.val!=prev.val)
                return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}