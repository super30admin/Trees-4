// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */

// Iterative
var lowestCommonAncestor = function(root, p, q) {
    if (!root) return new TreeNode();
    
    while (root != null) {
        if (p.val > root.val && q.val > root.val) root = root.right;
        else if (p.val < root.val && q.val < root.val) root = root.left;
        else return root;
    }
};

// Recursive
// var lowestCommonAncestor = function(root, p, q) {
//     if (!root) return new TreeNode();

//     if (p.val < root.val && q.val < root.val) {
//         return lowestCommonAncestor(root.left, p, q);
//     } else if (p.val > root.val && q.val > root.val) {
//         return lowestCommonAncestor(root.right, p, q);
//     } else {
//         return root;
//     }
// };
