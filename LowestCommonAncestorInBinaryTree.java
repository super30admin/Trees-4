// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Approach : We navigating through the left subtree and right subtree and return when we find null, p or q. If we get both left and right as non null, that means
// we found p and q under that root and return the root. If either of one is null, we return the one that has value. If both are null, we return null. We continue
// until we parse all nodes.

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){ //base case
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){ //when both left and right are non null, root is the ancestor
            return root;
        } else if(left == null && right != null){ //return the non null node
            return right;
        } else if(right == null && left != null){ //return the non null node
            return left;
        } else{ //when both left and right are null
            return null;
        }
    }
}