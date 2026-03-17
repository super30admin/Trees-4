
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //Time - O(n) -> worst case 
 //Space - O(n) -> worst case

 /**
 * Uses inorder traversal (LNR) on BST to visit nodes in sorted order.
 * The kth visited node during traversal is the answer.
 * Stops traversal early once kth element is found.
 *
 * Time Complexity: O(n) worst case
 * Space Complexity: O(h) recursion stack (O(n) worst, O(log n) avg for balanced tree)
 */

class KthSmallestElementInBST {
    TreeNode result;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        helper(root, k);
        return result.val;
    }

    public void helper(TreeNode root, int k) {
        // Stop recursion if node is null OR result already found (early pruning)
        if (root == null || result != null) {
            return;
        }

        helper(root.left, k);

        // Inorder traversal ensures nodes are visited in ascending order
        count++;

        // Invariant: count == number of nodes processed so far in sorted order
        if (k == count) {
            result = root; // Capture kth smallest node
            return; // Optional: slight optimization, avoids unnecessary right traversal
        }

        helper(root.right, k);
    }
}