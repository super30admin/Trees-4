// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class LowestCommonAncestorInaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root){return null;}
        TreeNode leftLCA = lowestCommonAncestor(root.left,p,q);
        if(root.val == p.val || root.val == q.val){return root;}
        TreeNode rightLCA = lowestCommonAncestor(root.right,p,q);
        if(leftLCA != null && rightLCA != null){return root;}
        return (null != leftLCA)?leftLCA:rightLCA;
    }
}