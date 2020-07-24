/*
Time Complexity : O(logn)    n-number of nodes
Space Complexity : O(h)   h-Height of tree //not using any datastructure but it will use stack
*/


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}