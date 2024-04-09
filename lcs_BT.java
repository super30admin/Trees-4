// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: check if the tree is null or if the p n q are present at root then return root else check the left and right with recursion
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if(left == null && right == null){
            return null;
        }else if( left != null && right == null){
            return left;
        }else if( left == null && right != null){
            return right;
        }else return root;
    }
}
