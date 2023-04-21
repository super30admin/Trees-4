// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Keep storing left and right treenodes of a treenode. 
 * Check if the left and right is null, if yes return null
 * If left is not null and right is null, return left and vice versa. 
 */

public class Problem2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q)
                return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left == null && right == null)
                return null;
            if(left == null && right != null)
                return right;
            else if(left != null && right == null)
                return left; 
            else 
                return root;
        }
}
