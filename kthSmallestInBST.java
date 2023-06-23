// TC - O(n) - tree traversal
// SC - O(h) - height of the tree

// Approach
// We do an inorder traversal of the tree and keep track of the number of nodes
// we have visited. When we reach the given number of nodes, that is the k-th
// smallest element. This works because the given tree is a binary search tree,
// where the inorder traversal would give us the ascending order of elements.

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
class Solution {
    int count;
    TreeNode elem;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }

        count = 0;
        inorder(root, k);
        if(elem == null) {
            return -1;
        }
        return elem.val;
    }

    public void inorder(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        inorder(root.left, k);
        count++;
        if(count == k) {
            elem = root;
            return;
        }
        inorder(root.right, k);
    }
}