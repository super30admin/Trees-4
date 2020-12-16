// Time Complexity :  O(log N)  - reject subtrees based on value
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            int parent = node.val;

            if (p.val > parent && q.val > parent) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (p.val < parent && q.val < parent) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {   
                return node;
            }
        }
        return null;
    }
}