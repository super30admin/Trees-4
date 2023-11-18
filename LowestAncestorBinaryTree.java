// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class LowestAncestorBinaryTree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || p == root || q == root)
                return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left == null && right ==null){
                return null;
            }
            else if(right != null && left == null){
                return right;
            }
            else if(left != null && right == null){
                return left;
            }
            else{
                return root;
            }
        }
    }
}
