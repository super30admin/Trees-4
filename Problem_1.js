// Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

// TC: O(h+k)
// SC: O(h)

// Optimized - preventing unwanted calls
// TC: O(k)
// SC: O(h)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
let result, counter;
var inorder = function (root, k) {
    if (root === null)
        return;

    // Logic
    if (result === -1)
        inorder(root.left, k);
    counter++;
    if (counter === k) {
        result = root.val;
        return;
    }
    if (result === -1)
        inorder(root.right, k);
}

/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function (root, k) {
    if (root === null)
        return -1;

    result = -1;
    counter = 0;
    inorder(root, k);
    return result;
};

