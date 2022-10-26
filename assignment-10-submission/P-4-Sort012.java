//Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The
//task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to the head
//side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.
public class P_4_Sort012 {
    // Definition for singly-linked list.
//   public class Node {
//       int val;
//       Node next;
//       Node() {}
//       Node(int val) { this.val = val; }
//       Node(int val, ListNode next) { this.val = val; this.next = next; }
//   }
    public Node sort012(Node curr){
        //Approach: here we have list with elements belongs of the set{0,1,2}.our target is to sort it.
        //we create three new lists and we iterate trough out the given list.
        //we add all 0's 1's 2's to three seperate lists and add join all the three lists.
        //start for list containing 0's
        Node zerostart = null;
        //end for list containing 0's
        Node zeroend = null;
        //start for list containing 1's
        Node onestart = null;
        //end for list containing 1's
        Node oneend = null;
        //start for list containing 2's
        Node twostart = null;
        //end for list containing 2's
        Node twoend = null;
        Node start = null;
        while (curr != null){
            if(curr.data == 0){
                if(zerostart == null){
                    zerostart = new Node(0);
                    zeroend = zerostart;
                }
                else{
                    zeroend.next = new Node(0);
                    zeroend = zeroend.next;
                }
            }
            if(curr.data == 1){
                if(onestart == null){
                    onestart = new Node(1);
                    oneend = onestart;
                }
                else{
                    oneend.next = new Node(1);
                    oneend = oneend.next;
                }
            }
            if(curr.data == 2){
                if(twostart == null){
                    twostart = new Node(2);
                    twoend = twostart;
                }
                else{
                    twoend.next = new Node(2);
                    twoend = twoend.next;
                }
            }
            curr = curr.next;
        }
        
        //join all the lists and return start of it.

        if(zerostart != null){
            start = zerostart;
        } else if (onestart != null) {
            start = onestart;
        } else if(twostart != null){
            start = twostart;
        }
        if(zeroend != null){
            if(onestart != null)
                zeroend.next = onestart;
            else
                zeroend.next = twostart;
        }
        if(oneend != null){
            oneend.next = twostart;
        }
        return start;
    }
}
