/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        while(temp!=null){
            Node copyNode=new Node(temp.val);
            copyNode.next=temp.next;
            temp.next=copyNode;
            temp=temp.next.next;
        }
        Node temp2=head;
        while(temp2!=null){
            Node copyNode=temp2.next;
            if(temp2.random!=null)
             copyNode.random=temp2.random.next;
            else copyNode.random=temp2.random;
            temp2=temp2.next.next;
        }
        Node dummy=new Node(-1);
        Node res=dummy;Node temp3=head;
        while(temp3!=null){
            res.next=temp3.next;
            temp3.next=temp3.next.next;
            res=res.next;
            temp3=temp3.next;
        }
        return dummy.next;
    }
}