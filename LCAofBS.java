// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// traverse the entire tree and check l and r
// left indicates if the first found is in left part of the tree, likewise for right
// check for left is present and right is null at root -> both lie in the left tree -> return the first node found
// if both are present return the root node of the found level

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if( root == null || root == p || root == q)  //returning the first found level
            return root;

        TreeNode left = lowestCommonAncestor(root.left , p, q);
        TreeNode right = lowestCommonAncestor(root.right , p, q);

        if(left == null && right == null) return null;
        else if(left != null && right == null) return left;
        else if(left == null && right != null) return right;
        else return root;
        
    }
}