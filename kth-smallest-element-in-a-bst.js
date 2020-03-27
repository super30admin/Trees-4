// Time Complexity : O(H + k)
// Space Complexity : O(H) stack size
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
 * @param {number} k
 * @return {number}
 */


// Recursive without array
let K,
    result;
var kthSmallest = function(root, k) {
    if (!root) return 0;
    
    K = k;
    
    inorder(root);
    return result;
};

var inorder = function(root) {
    if (root == null) return;
    
    inorder(root.left);
    K--;
    if (K == 0) {
        result = root.val;
        return;
    }
    inorder(root.right);
};

// Iterative without array
// var kthSmallest = function(root, k) {
//     if (!root) return 0;
    
//     const stack = [];
//     let cursor = root;
    
//     while (cursor != null) {
//         stack.push(cursor);
//         cursor = cursor.left;
//     }

//     while (stack.length > 0) {
//         cursor = stack.pop();
        
//         k--;
//         if (k == 0) return cursor.val;
        
//         if (cursor.right != null) {
//             cursor = cursor.right;
//             while (cursor != null) {
//                 stack.push(cursor) ;
//                 cursor = cursor.left;
//             }
//         }
//     }
    
//     return 0;
// };

// Recursive using an array
// var kthSmallest = function(root, k) {
//     if (!root) return 0;
//     let inorderTraversal = inorder(root, []);
//     return inorderTraversal[k - 1];
// };

// var inorder = function(root, arr) {
//     // Base Case
//     if (root == null) return arr;
//     // Logic
//     inorder(root.left, arr);
//     arr.push(root.val);
//     inorder(root.right, arr)
//     return arr
// }
