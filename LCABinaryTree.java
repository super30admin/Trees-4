// Time Complexity : O(N) where N is the number of nodes
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Check left side of tree and right side, if both present then root is the ancestor
public class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || root==p || root==q) return root;

        TreeNode left=lowestCommonAncestor(root.left, p,q);
        TreeNode right= lowestCommonAncestor(root.right, p,q);

        if(left==null && right==null) return null;
        if(left==null && right!=null) return right;
        if(left!=null && right==null) return left;

        return root;
    }
}

