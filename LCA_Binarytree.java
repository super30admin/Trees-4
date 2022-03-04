
// Time Complexity :o(n)
// Space Complexity :o(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        if(root == null || root == p || root == q)
        {
            return root;
        }
 
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null && right != null) return right;
        if(right == null && left != null) return left;
        if(left == null && right == null) return null;
        return root;
        
    }
}
