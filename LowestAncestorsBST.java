// Time Complexity : O(logn)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class LowestAncestorsBST {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null)
                return null;

            if(p.val < root.val && q.val < root.val){
                return lowestCommonAncestor(root.left, p, q);
            }

            if(p.val > root.val && q.val > root.val){
                return lowestCommonAncestor(root.right, p, q);
            }

            return root;
        }
    }
}
