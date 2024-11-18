// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


 class Solution {
    //aesha
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         while(true)
    {
        if(p.val < root.val && q.val < root.val) root = root.left;
        else if(p.val >root.val && q.val > root.val) root = root.right;
        else return root;   
    }
    }
}