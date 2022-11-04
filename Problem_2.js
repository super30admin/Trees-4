// Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

// Time Complexity : O(h); h is the tree height
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
var lowestCommonAncestor = function (root, p, q) {
    // Recursive

    if (root === null)
        return root;
    // If both values are less than root, go on left
    if (p.val < root.val && q.val < root.val) {
        return lowestCommonAncestor(root.left, p, q)
    } else if (p.val > root.val && q.val > root.val) {
        // Else go on right
        return lowestCommonAncestor(root.right, p, q)
    } else {
        // Ans found
        return root;
    }
    // Iterative

    // while(true){
    //     if(p.val<root.val && q.val<root.val){
    //         root = root.left;
    //     } else if(p.val>root.val && q.val>root.val){
    //         root = root.right;
    //     } else {
    //         return root;
    //     }
    // }
};
