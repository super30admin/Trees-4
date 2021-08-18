// Time Complexity : O(log n), n -> Number of nodes in the tree, log n -> Height of Tree
// Space Complexity : O(1)
class Solution {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        
        while(true) {
            if(root.val<p.val && root.val<q.val)
                root = root.right;
            else if(root.val>p.val && root.val>q.val)
                root = root.left;
            else {
                return root;
            }  
        }
    }
}