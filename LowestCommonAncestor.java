// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    Since BST has the elements in order, we check if one element is on the left subtree and the other on the right subtree
    Or if we are on one of the elements. If so, we have the common ancestor. 
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == p || root == q) return root;
                
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
         
        return root;
    }
}