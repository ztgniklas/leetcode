public class Solution {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> hs = new HashSet<>();
        ListNode h1 = head;
        while(h1!=null){
            if(hs.contains(h1))
                return true;
            else{
                hs.add(h1);
                h1 = h1.next;
            }  
        }
        return false;
    }

}