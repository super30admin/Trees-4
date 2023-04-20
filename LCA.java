/**
 * Time Complexity - O(H) where H is the height of the BST.
 * Space Complexity - O(H)
 * In the case of skewed tree, H is equal to N where N is the number of nodes in the tree.
 * In a perfectly balanced tree, H is equal to log N.
 */
 
class Solution {
    Integer count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = getLca(root, p, q);
        return (ancestor != null) ? ancestor : null;
    }
    public TreeNode getLca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        
        TreeNode left = getLca(root.left, p, q);
        TreeNode right = getLca(root.right, p, q);

        if(root == p || root == q) 
            return root;

        if(left != null && right != null)
            return root;
        if(left != null)
            return left;
        return right;
    }
}
