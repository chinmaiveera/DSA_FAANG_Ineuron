//BELOW CODE SUCCESSFULLY EXECUTED AND PASSED 100% OF TESTCASES ON LEETCODE
class InvertBinaryTree {
    //below function takes the root of a binary tree and returns root of inverted binary tree.
    public TreeNode invertTree(TreeNode root) {
        //breakpoint. if root is null means we reached end.
        if(root == null)
            return root;
        //swap roots of left and right subtrees
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        //recursively do the same to left and right subtrees
        invertTree(root.left);
        invertTree(root.right);
        //return root
        return root;
    }
}
