// Finding LCA for BST 
//recursive
//time o(n)
//space o(logn), recursive stack space
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root!=null && p.val < root.val && q.val < root.val )
            return lowestCommonAncestor(root.left, p, q);
        else if(root!=null && p.val > root.val && q.val > root.val )
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}

//iterative
//space o(1)
//time o(n) as it is normal binary search tree, o(logn) if it is a balanced binary search tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(root != null) {
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            else
                return root;
        }
        return null;
    }
}