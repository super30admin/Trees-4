// Time Complexity : O(k + h) on average when the k-th smallest is found after exploring ~k nodes with recursion depth up to tree height h; worst case O(n) if k ≈ n or the tree is skewed.
// Space Complexity : O(h) due to the recursion stack (h = height of the tree; O(log n) for balanced, O(n) for skewed).
// Did this code successfully run on Leetcode : Yes

Approach :

// The algorithm uses the BST property that an in-order traversal (left, node, right) visits nodes in ascending order.
// It maintains a global count of visited nodes and a res pointer to hold the k-th node when found.
// During traversal, it first explores the left subtree; after returning, it increments count and checks if count == k to set res.
// If res is still null, it proceeds to the right subtree, effectively pruning further recursion once the answer is found.
// Finally, kthSmallest returns res.val, which is guaranteed to be set under valid constraints (1 ≤ k ≤ n).

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
    TreeNode res;
    public int kthSmallest(TreeNode root, int k) {
        this.count =0;
        this.res= null;
        helper(root,k);
        return res.val;
    }

    private void helper(TreeNode root, int k){
        if(root == null) return;
        if(res == null)
            helper(root.left,k);
        count++;
        if(k == count)
            res = root;
        if(res == null)
            helper(root.right,k);
    }
}
