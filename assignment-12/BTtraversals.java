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
//Note:No driver code all the solutions are accepted on leetcode
class BTtraversals {
    //this function takes root of current tree and return the preorder traversal of it.
    public List<Integer> preorderTraversal(TreeNode root) {
        //declare the final array that going to be returned
        ArrayList<Integer> arr = new ArrayList<Integer>();
        //create an empty stack
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode curr;
        //if root node is not null add it to stack
        if(root != null)
        add(root,arr,stk);
        //start a loop that will be continued until stack is empty
        while(!stk.isEmpty()){
            //take top of the stack as current node
            curr = stk.peek();
            //if both children of node are empty pop it from stack
            if(stk.peek().left == null && stk.peek().right ==  null)
                stk.pop();
            //if left child is empty add right child to stack and also to final array.
            else if(stk.peek().left == null){   
                add(stk.peek().right,arr,stk);
                //make right child of current node to null to avoid repetition.
                curr.right = null;
            }
            else { //if left child is empty add left child to stack and also to final array.
                add(stk.peek().left,arr,stk);
                //make left child of current node to null to avoid repetition.
                curr.left = null;
            }
        }
        // return the final array.
        return arr;
    }
    public void add(TreeNode node,List<Integer> list,Stack<TreeNode> stk){
        //this function adds the value of node to final array and adds node to stack
        list.add(node.val);
        stk.push(node);
    }
  //this function takes root of current tree and return the inorder traversal of it.
    public List<Integer> inorderTraversal(TreeNode root) {
        //declare the final array that going to be returned
        ArrayList<Integer> arr = new ArrayList<Integer>();
        //create an empty stack
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode curr;
        //if root node is not null add it to stack
        if(root != null)
            stk.push(root);
        //start a loop that will be continued until stack is empty
        while(!stk.isEmpty()){
            //take top of the stack as current node
            curr = stk.peek();
            System.out.println(stk.peek().val);
            //if both children of node are empty pop it from stack and add its value to final array.
            if(curr.left == null && curr.right ==  null){
                arr.add(curr.val);
                stk.pop();
            }
            //if left child is null add nodevalue to final array,push right child to stack 
            //and pop current node to avoid repetiton
            else if(stk.peek().left == null){
                stk.pop();
                stk.push(curr.right);
                arr.add(curr.val);
            }
            else { 
                //if left child is present then push it to stack and make current node left as null to avoid repetition.
                stk.push(curr.left);
                curr.left = null;
            }
        }
        //return final array
        return arr;
    }
  //this function takes root of current tree and return the postorder traversal of it.
    public List<Integer> postorderTraversal(TreeNode root) {
        //declare the final array that going to be returned
        ArrayList<Integer> arr = new ArrayList<Integer>();
        //create an empty stack
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode curr;
        //if root node is not null add it to stack
        if(root != null)
            stk.push(root);
        //start a loop that will be continued until stack is empty
        while(!stk.isEmpty()){
            //take top of the stack as current node
            curr = stk.peek();
            //if both children are empty add node value to final array 
            //and pop current node from stack
            if(curr.left == null && curr.right ==  null){
                arr.add(curr.val);
                stk.pop();
            }//if left child is empty then add right child to stack and make current right as null to avoid repetition.
            else if(stk.peek().left == null){   
                stk.push(curr.right);
                curr.right = null;
            }
            //if left child is not empty then add left child to stack and make current left as null to avoid repetition.
            else { 
                stk.push(curr.left);
                curr.left = null;
            }
        }
        //return final array
        return arr;
    }
}
