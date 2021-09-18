//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
/*
Time: O(N) where N = Number of nodes in the Tree
Space: O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class LCAofBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q)
            return root;

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both are not null return root;
        if (leftLCA != null && rightLCA != null)
            return root;

        // If one of them are not null, return them
        return leftLCA != null ? leftLCA : rightLCA;

    }

}
