/*
使用map链接head和copyhead的每个对应结点
再在第二个循环中确定next和random即可
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node h1 = head;
        Map<Node,Node> hm = new HashMap<>();
        while(h1!=null){
            hm.put(h1,new Node(h1.val));
            h1 = h1.next;            
        }
        h1 = head;
        while(h1!=null){
            hm.get(h1).random = hm.get(h1.random);
            hm.get(h1).next = hm.get(h1.next);
            h1 = h1.next;
        }
        return hm.get(head);
    }
}