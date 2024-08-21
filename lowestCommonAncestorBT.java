/**
 * Time Complexity: O(n), where n is the number of nodes in the binary tree.
 * In the worst case, the function needs to visit every node to find the lowest common ancestor, which requires O(n) time.

 * Space Complexity: O(h), where h is the height of the binary tree.
 * The space complexity is due to the recursive call stack. In the worst case, the recursion depth can go up to the height of the tree, which is O(h).
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the current node is null, return null
        if (root == null)
            return null;
        
        // If the current node is either p or q, return the current node
        if (root == p || root == q)
            return root;
        
        // Recursively find the lowest common ancestor in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        
        // Recursively find the lowest common ancestor in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right subtrees return null, it means neither p nor q are found in the current subtree
        if (left == null && right == null)
            return null;
        
        // If the left subtree returned a node and the right subtree returned null, return the node from the left subtree
        if (left != null && right == null)
            return left;
        
        // If the right subtree returned a node and the left subtree returned null, return the node from the right subtree
        if (right != null && left == null)
            return right;
        
        // If both left and right subtrees returned non-null nodes, it means p and q are in different subtrees
        // Hence, the current node is the lowest common ancestor
        return root;
    }
}
