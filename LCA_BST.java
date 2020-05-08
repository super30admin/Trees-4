// Time Complexity :O(n)
// Space Complexity :O(max depth)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        
        if(p.val==root.val || q.val == root.val)
            return root;
        else if ((p.val > root.val && q.val < root.val) ||(p.val < root.val && q.val > root.val) )
            return root;
        
        else if (p.val> root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        
        return root;
    }
}
