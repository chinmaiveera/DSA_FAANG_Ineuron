/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//BELOW CODE EXECUTED AND ACCEPTED ON LEETCODE.

//Recover Binary Search Tree
class RecoverTree {
    //this function takes the root node of tree and rearrange the two swapped elements
    public void recoverTree(TreeNode root) {
        //create an array list that stores the nodes
        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        //below function takes the root of tree and empty array.
        //Then fill the array with tree nodes in inorder of tree.
        inorder(root,arr);
        TreeNode first=null;
        TreeNode second=null;
        //we know that exactly two elements are misplaced and 
        //in bst inorder of a tree is nothing but ascending order of values of its nodes.
        //So,we loop trough the array and store the misplaced nodes in "first","second" variables.
        for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i).val>arr.get(i+1).val){
                if(first == null){
                    first = arr.get(i);
                    second = arr.get(i+1);
                }
                else
                    second = arr.get(i+1);
            }
        }
        //now swap the values of "first" and "second" nodes.
        swap(first,second);
        //TimeComplexity:
        //  for Inorder traversal: n,where n is total elements of tree.
        //  for searching:n,where n is total elements of tree.
        //  for swapping:1
        //Therefore TimeComplexity will be n+n+1 ~ O(n)
        
    
    }
    //below function takes the root of tree and empty array.
    //Then fill the array with tree nodes in inorder of tree.
    public void inorder(TreeNode root,ArrayList<TreeNode> arr){
        if(root==null)
            return;
        inorder(root.left,arr);
        arr.add(root);
        inorder(root.right,arr);
    }
    //below function takes the two nodes and swap their values.
    public void swap(TreeNode first,TreeNode second){
        int temp;
        temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
