// Time Complexity : O(log h) -> height of the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// if both value lies in the left side of the tree, traverse further
// same for right
// if the are split -> return the root at which the split happens

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return root;

        if(p.val < root.val && q.val< root.val){
            return lowestCommonAncestor(root.left,p,q);
        } else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        } else
            return root;
    }

}