    /**
    Time Complexity : O(H + K)
    Explanation:
    Inorder traversal visits nodes in sorted order.
    We stop once we reach the k-th smallest, so we don’t traverse entire tree.
    H = height of tree.

    Space Complexity : O(H)
    Explanation:
    Recursion stack goes up to tree height.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially stored all elements in a list which takes O(N) space.
    Optimized by stopping traversal once k-th element is found,
    avoiding unnecessary work.
    */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 * }
 */

class Solution {



    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {

        if (root == null) return;

        inorder(root.left, k);

        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        inorder(root.right, k);
    }
}