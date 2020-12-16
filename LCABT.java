// Time Complexity :  O(N) Traversing all the elemnts
// Space Complexity : O(N) - recursive stack space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.ans = null;
        recurse(root, p ,q);
        return this.ans;
    }
    private boolean recurse(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;
        int curr = 0;
        if(node.val == p.val || node.val == q.val) 
            curr = 1;
        int left = recurse(node.left, p,q) ? 1: 0;
        int right = recurse(node.right, p,q) ? 1: 0;
        
        
        if(left + curr + right >=2){
            ans = node;
        }
        return (curr + left + right > 0);
    }
    
}