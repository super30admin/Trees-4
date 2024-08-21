//Time = O(h)
//Space = O(h), h is height of the binary search tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null; // Base case

        if (p.val < root.val && q.val < root.val) { // p and q are both in the left subtree
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) { // p and q are both in the right subtree
            return lowestCommonAncestor(root.right, p, q);
        } else { // p and q are on different sides of the root
            return root;
        }
    }
}
