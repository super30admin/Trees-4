// Time Complexity : O(h)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes




class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            } else if(root.val < p.val && root.val < q.val){
                root = root.right;
            } else{
                return root;
            }
        }
        return null;
    }
}

