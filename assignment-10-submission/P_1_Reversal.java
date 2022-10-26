
//Given a singly linked list, give me the reversal of the linked list.


class P_1_Reversal {

// Definition for singly-linked list.
//   public class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//   }


    //this function takes the head of linked list and reverse it and returns new head.
    public ListNode reverseList(ListNode head) {
        //if list is empty return null
        if(head == null)
            return null; 
        return reverse(head,null);
        //Time Complexity: O(n)
    }
    //this recusive function takes the current and previous node and reverse  the direction
    public ListNode reverse(ListNode curr,ListNode prev){
        if(curr.next == null){
            curr.next = prev;
            //the last element will be new head so return the new head
            return curr;
        }
        ListNode top = reverse(curr.next,curr);
        //current element points towards previous.
        curr.next = prev;
        return top;
    }
}