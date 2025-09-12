
//Time Complexity: O(h) where h is the height of the tree
//Space Complexity: O(h) where h is the height of the tree


//we need to find the lowest common ancestor of two nodes in a Binary tree
// we do bottom up approach we check if the current node is either p or q, if yes we return that node
// we recursively call left and right subtree
// if left is null we return right, if right is null we return left
// if both left and right are not null we return root

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val==p.val || root.val==q.val)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
}