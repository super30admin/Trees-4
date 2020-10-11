    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    Time Complexity for operators : o(nlogn) .. n is the length of the string
    Extra Space Complexity for operators : o(1)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Trverse on both the side left and right.
                    B) If root value is equal to p.val or q.val then return root in recursive call.
                    C) store the left and right pointer when traversing on left and right side.
                    D) If left and right both not null means both elements on the left and right side LCA will be root.
                    E) If left is not null and right is null means our LCA is left.
                    F) Else return right as LCA.
    */  
    
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        
        if(root.val == p.val || root.val == q.val)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left!=null && right!=null)
            return root;
        else if(left!=null && right == null)
            return left;
        else
            return right;
    }
}