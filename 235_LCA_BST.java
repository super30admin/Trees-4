    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    Time Complexity for operators : o(n) .. n is the number of nodes in tree.
    Extra Space Complexity for operators : o(1)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Recursive call and check values but it requires more space than the oprmized one.
        # Optimized approach: 
                              
            # 1. 
                    A) Trverse till root is not equal to null.
                    B) if value of p is greater than root value and value of q also greater then our LCA is on right side.
                    C) if value of p is lesser than root value and value of q also lesser then our LCA is on left side.
                    D) if both is not possible then  return the root.
                    E) At the end, return root.
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
        
        if(root == null) return root;
        
        // if(p.val > root.val && q.val>root.val)
        //     return lowestCommonAncestor(root.right,p,q);
        // else if(p.val < root.val && q.val < root.val)
        //     return lowestCommonAncestor(root.left,p,q);
        // else
        //     return root;
        
        while(root!=null){
            if(p.val > root.val && q.val > root.val)
                root = root.right;
            else if(p.val < root.val && q.val < root.val)
                root = root.left;
            else return root;
        }
        return root;
    }
}