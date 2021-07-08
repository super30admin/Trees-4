/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
230. Kth Smallest Element in a BST
Medium

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?


 * Solution 1: using Inorder traversal
   Time Complexity : O(n)
 * Space complexity :O(1)
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int value; /* final result */
    int path; /* path count encountered so far */
    int k_internal; /* using copy of k to avoid stack size for function having unnecessary overhead */
    void inorder(TreeNode* root) {
        if (root == NULL) {
            return;
        }
        inorder(root->left);
        /* count the items, once it becomes equal to k, we get the result, return from here */
        path = path + 1;
        if (path == k_internal) {
            value = root->val;
            return;
        }
        inorder(root->right);
    }
    
    int kthSmallest(TreeNode* root,int k) {
        value = 0;
        path = 0;
        k_internal = k;
        inorder(root); 
        return value;
    }
};
/* Execute on leetcode platform */


