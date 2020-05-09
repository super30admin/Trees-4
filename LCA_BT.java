// Time Complexity :O(n)
// Space Complexity :O(max depth)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        
        if(p==root || q==root){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left!=null && right!=null){
            return root;
        }
        else if(left!=null && right==null){
            return left;
        }
        else{
            return right;
        }
    }
}
