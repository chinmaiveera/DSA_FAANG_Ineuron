/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//BELOW CODE EXECUTED AND ACCEPTED ON LEETCODE.

//Lowest Common Ancestor of a Binary Search Tree
class LowestCommonAncestor {
    //below function takes the root node and other two node part of same tree and
    //return the common ancestor of given two nodes.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //declare queues "q1","q2" that store all the ancestor nodes of "p" and "q" respectively
        Queue<TreeNode> q1 = findabove(root,p);
        Queue<TreeNode> q2 = findabove(root,q);
        TreeNode prev=root;
        //run loop trough both queues parellely and find the last common ancestor of both nodes.
        while(q1.peek() == q2.peek()){
            prev = q1.peek();
            q1.remove();
            q2.remove();
        }
        //return that ancestor.
        return prev;
    //TIME COMPLEXITY:
    //  for finding all ancestors: 
    //    maximum no of ancestors a node can have is (h-1),where h is height of tree.
    //  for finding last common ancestor: 
    //    h,as queue contains all ancestors and
    //    max no of  ancestors a node can have is (h-1),where h is height of tree.
    //So,time complexity is O(h),where h is height of tree.
    //BEST/AVG CASE:
    //    least/avg height of bst can be is logn where n is total no of elements.
    //    So,O(h) = O(logn)
    //WORST CASE:
    //    maximum height bst can have is logn where n is total no of elements.
    //    So,O(h) = O(n)
    }
    
    
    //below function takes the root node and target node,
    //returns queue containing all ancestors of target node.
    public Queue<TreeNode> findabove(TreeNode root,TreeNode target){
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        while(root!=null){
            que.add(root);
            if(root.val == target.val)
                break;
            if(root.val > target.val)
                root = root.left;
            else
                root = root.right;
        }
        return que;
    }
}
