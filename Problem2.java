// There are two approaches
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Approach 1: Using DFS iterative
// Time Complexity : O(h) = O(log n)
//      h: height of the tree
//      n: number of elements
// Space Complexity : O(1)
//    Since we are just changing root reference
// Note this is BST so h = log n
class Problem2S1 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /** find lowest common ancestor */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        // iterate all elements
        while(root != null){

            // both p and q less than root go to left sub tree
            if(root.val>p.val && root.val > q.val)
                root = root.left;
            // both p and q greater than root go to right sub tree
            else if(root.val < p.val && root.val < q.val)
                root = root.right;
            // root is the lowest common ancestor
            else
                return root; // also take care of root = p or q 
            
        }
        // edge case
        return null;
    }
}
// Your code here along with comments explaining your approach
// Approach 2: Using DFS recursive
// Time Complexity : O(h) = O(log n)
//      h: height of the tree
//      n: number of elements
// Space Complexity : O(h) = O(log n)
//      h: height of the tree
//      n: number of elements
// Note this is BST so h = log n
class Problem2S2 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /** find lowest common ancestor */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // edge case check
        if(root!=null) {

            // both p and q are less so search left-sub tree
            if(root.val>p.val && root.val > q.val)
                return lowestCommonAncestor(root.left,p,q);
            // both p and q are greater so search right-sub tree
            else if(root.val < p.val && root.val < q.val)
                return lowestCommonAncestor(root.right,p,q);
            // root is the lowest common ancestor
            else
                return root;// also take care of root = p or q 
        }
        // default
        return null;      
       
    }
}