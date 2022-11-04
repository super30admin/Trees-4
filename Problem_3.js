// Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

// Top-Bottom 
// Time Complexity : O(n)+O(2h)
// Space Complexity : O(h)

// Bottom-Up
// Time Complexity : O(n)
// Space Complexity : O(h)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

let pathP;
let pathQ;
let backtrack = (root, p, q, path) => {
    // Base
    if (root === null)
        return;

    // Logic
    if (root === p) {
        pathP = Array.from(path);
        pathP.push(root.val);
        return;
    }
    if (root === q) {
        pathQ = Array.from(path);
        pathQ.push(root.val);
        return;
    }
    path.push(root.val);
    backtrack(root.left, p, q, path);
    backtrack(root.right, p, q, path);
    path.pop();
}
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
    //     if(root === null || root === p || root === q)
    //         return root;
    //     // Top bottom approach
    //     // Maintain path of each found element. find lca
    //     pathP = [];
    //     pathQ = [];
    //     let path = [];
    //     backtrack(root, p, q, path);
    //     for(let i=0; i<pathP.length; i++){
    //         if(pathP[i] !== pathQ[i]){
    //             return pathP[i-1];
    //         }
    //     }

    // Bottom up approach
    // if we found the null or nodes, return root
    if (root === null || root === p || root === q)
        return root;

    // Recurse
    let left = lowestCommonAncestor(root.left, p, q);
    let right = lowestCommonAncestor(root.right, p, q);

    // If none found in both left and right subtrees, return null
    // If any one found, return that
    // If found both, this is the lca so return it.
    if (left === null && right === null) {
        return null;
    } else if (left === null) {
        return right;
    } else if (right === null) {
        return left;
    } else {
        return root;
    }

};
