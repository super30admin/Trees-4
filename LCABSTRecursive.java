//TC: O(n) n is the number of nodes in the tree
//SC: O(H) - height of tree recursive stack space

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null ) return null;
        
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
        else if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);
        else{
            return root;
        }
        
    }
}