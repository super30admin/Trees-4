/**

Time: O(N)  N is number of nodes in tree
Space: O(H) stack space 
Approach:
========
1. Check for p and q in left and right subtrees. Return them if found, if not return null
2. If left and right are not null, both p and q are found and that would be the LCA for both
 */
class Solution {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) 
            return root;=====
        
        //p or q found, return root
        if(root.val == p.val || root.val == q.val)
            return root;
        
        //call method on left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null)   //left and right both are not null
            return root;
        else if(left != null)           // left is not null
            return left;
        else if(right != null)          //right is not null
            return right;
        else
            return null;
    }
    
    
}
