// Time Complexity : O(H)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        while(true) {
            if(p.val < root.val && q.val < root.val)
                root = root.left;
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
    }
}