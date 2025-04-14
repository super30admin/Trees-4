// In this problem, we will use the property of Binary search tree, that left is smaller than root and root is smaller than right.
// So, we will start traversing the BST, compare values of p and q if smaller than root that means, we will move to left subtree,
// else if greater than root that means we will move to right subtree. If at any point we are not able to move left or right, that
// means we are at the correct node and we will return the root.

// Time Complexity : O(H) H is height of the tree
// Space Complexity : O(H) recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Recursive
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if (root == null) {
            return root;
        }
        // Compare values of p and q if greater than root
        if (root.val < p.val && root.val < q.val) {
            // move to root.right
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            // Else if smaller than root, move to root.left
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // Else unable to pick, means we are on the correct node, so return root
            return root;
        }
    }
}

// Time Complexity : O(H) H is height of the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Iterative solution
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        while (true) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
    }
}