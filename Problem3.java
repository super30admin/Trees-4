//lowest common ancestor in a binary tree
//recursive
//time o(n)
//space o(logn)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root == null || p == root || q == root)
            return root;
        
        //logic
        TreeNode lSide = lowestCommonAncestor(root.left, p, q);
        TreeNode rSide = lowestCommonAncestor(root.right, p, q);
        
        if(lSide != null && rSide != null)
            return root;
        else if(lSide !=null)
            return lSide;
        else if(rSide != null)
            return rSide;
        return null;
    }
}