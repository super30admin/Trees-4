// Time Complexity : O(n) - where n is the number of nodes in the tree.
// Space Complexity : O(h) - where h is the height of the tree which is logn
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes , to think about the way or implementation.


// Your code here along with comments explaining your approach: Recursive approach of Finding the p and q on the left and right subtrees. If both left and right are not null return root, or else take the side which is not null and recursively search on that particular subtree.




class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root==null||root.val==p.val||root.val==q.val) return root;
        //logic
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        else if(left==null) return right;
        else if(right==null) return left;
        else return null;
        
}
}