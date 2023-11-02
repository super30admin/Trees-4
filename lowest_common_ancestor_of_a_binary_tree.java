// # Time Complexity:  O(n) where n is the number of nodes
// #  Space Complexity:  O(h) where is the height of the tree. 
// #  Did this code successfully run on Leetcode : Yes
// #  Any problem you faced while coding this : No


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root.val > p.val && root.val > q.val) {
            return  lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }
}
