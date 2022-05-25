// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        while(true) {
            if(root.val < p.val && root.val < q.val) {
                root = root.right;
            } 
            else if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
    }
}