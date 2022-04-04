// Time Complexity : o(n) where n is number of nodes
// Space Complexity : o(h) where h is height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// when you find the element, return root,  you do not need to traverse the subtree
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

        if(root == null) return null;

        for(TreeNode node : nodes){
            if(root == node) return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);

        if( left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}
