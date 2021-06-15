/*
Desc : we move in same fashion as we did in LCA of BST ,we keep a constaint to stay clear from the
nodes that are missing either of the next pointers.
Time Complexity : O(n)
Space Complexity : O(h)
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        if(left==null && right==null) return null;
        return left!=null?left:right;
    }
}
