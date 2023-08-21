// Time Complexity : O(n)
// Space Complexity : O(log(n)))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
0. If root is null or root is p or root is q, return root.
1. If left and right are null, return null.
2. If left is not null and right is null, return left.
3. If left is null and right is not null, return right.
4. Else return root.
 */


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null){
            return null;
        }else if(left != null && right == null){
            return left;
        }else if(left == null && right != null){
            return right;
        }

        return root;
    }
}