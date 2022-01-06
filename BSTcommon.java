// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// T.C. O(n)
// S.C. O(n)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val)return root;
        if((p.val < root.val && q.val > root.val )|| (p.val > root.val && q.val < root.val ))return root;
        else if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else 
            return lowestCommonAncestor(root.right, p,q);  
    }
}