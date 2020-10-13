// Time Complexity : O(n) most of the times, worst case O(n) (Amortized O(n))
// Space Complexity : O(n) for recursive stack, else O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        if(root==p||root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        if(left!=null&&right!=null){
            return root;
        }
        else if(left!=null){
            return left;
        }
        else{
            return right;
        }
    }
}