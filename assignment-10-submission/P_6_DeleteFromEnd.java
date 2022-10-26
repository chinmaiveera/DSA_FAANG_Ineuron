
class Solution {
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
    //below function takes the head and removes the nth element from end in singly linked list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null)
            return null;
        ListNode temp = head;
        int count = 0;
        //iterate to find length of linkedlist.
        while(temp != null){
            count++;
            temp = temp.next;
        }
        //(n-1) from end will be length-n-1;
        count = count-n-1;
        //count<0 means target element is head.
        if(count < 0)
            return head.next;
        temp = head;
        //iterate trough the list till we find n-1th element front end or count th element from start
        while(count != 0){
            temp = temp.next;
            count--;
        }
        //now bypass the next node.
        temp.next = temp.next.next;
        return head;
        //TimeComplexity: O(n) as we iterate trough the list only once.
    }
}