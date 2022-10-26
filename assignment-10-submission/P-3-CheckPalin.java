//Write a function to check whether a given linked list is palindrome or not
class Solution {

// Definition for singly-linked list.
//   public class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//   }
    ListNode left;
    //this function takes the head of linked list and return true/false weather list is palindrome/not palindrome.
    public boolean isPalindrome(ListNode head) {
        //here we are taking the help of a global variable "left" serves as a left pointer.
        left = head;
        return ifpalin(head);
        //TimeComplexity:O(n) as we iterate troughout the list once
    }
    //this is a recursive function to find weather list is palindrome or not
    public boolean ifpalin(ListNode curr){
        //iterate till the last element, at every call in stack curr acts as right pointer
        if(curr.next == null){
            //if left equal to right increase left pointer and return true;else return false
            if(left.val == curr.val){
                left = left.next;
                return true;
            }
            else return false;
        }
        boolean bool = ifpalin(curr.next);
        //if previous elements are not in palindrome then there is no point in checking further so return false;
        if(!bool){
            return false;
        }
        //if left is equal to null it means we are way past the middle element.(means checking already completed)
        //So,just return the previous result;
        if(left == null){
            return bool;
        }
        //if we just crossed middle element or on the middle element there is no need to check further
        //So,make left as null.it serves as a flag that means checking is complete.
        //return previous result
        if( left == curr || curr.next == left){
            left = null;
            return bool;
        }
        //if left pointer is not equal to right return false else move left further and return true.
        if(left.val != curr.val)
            return false;
        left = left.next;
        return true;
    }
}