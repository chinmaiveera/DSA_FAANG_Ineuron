//Convert a singly linked list into a circular linked list
class P-2-Conver-to-circular{
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
//this functions takes the head of linear singly linked list and convert into circular linked list and returns head
public ListNode convert_to_circular(ListNode head){
    //copy head to temp;
    ListNode temp = head;
    //iterate trough linkedlist till last element
    while (temp.next != null){
        temp = temp.next;
    }
    //connect the head to last element
    temp.next = head;
    return head;
    //TimeComplexity: O(n) as we iterate trough the list once.
}
}