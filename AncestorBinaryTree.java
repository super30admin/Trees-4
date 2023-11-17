// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class AncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root == p || root== q)
        return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null && right==null)
            return null;
        else if(left==null && right!=null)
            return right;
        else if(right == null && left!=null)
            return left;
        return root;
    }
}