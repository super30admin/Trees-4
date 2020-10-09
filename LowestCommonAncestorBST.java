// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Recursion 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root== null){
            return null;
        }
        
        if (p.val> root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p,q);
        }else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p,q);
        }else{
            return root;
        }
    }
}
