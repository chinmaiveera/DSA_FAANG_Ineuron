public class P_5_CheckCycle {
    /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    //this function takes head of linked list and returns true if it has loop else false
    public boolean hasCycle(ListNode head) {
        //Point to be noted:
        //(i)in a circular path if two object are moving with different speeds they will collide at some point.
        //(ii) if we iterate trough a linked list that has a loop we will get stuck in that loop and iterate infinitely
        //and never reach end.
        
        //Approach: here we take two pointers.second pointer travels twice the speed of first pointer.
        //if they reach end we can conclude that the list has no loops.
        //if there is loop they both get stuck in loop, as they travell with different speeds they will definetly meet
        //at some point. At that point the both pointer become equal.
        if(head == null)
            return false;
        ListNode first = head;
        ListNode second = head.next;
        while(second != null && second.next != null){
            //if both pointers meet first will be equal to second. then return true.
            if(first == second)
                return true;
            first = first.next;
            second = second.next.next;
        }
        //pointer reached end so return false.
        return false;
        //TimeComplexity: O(n) as maximum time will be one iteration of slower pointer.
    }
}
