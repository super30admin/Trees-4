// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 
// Approach: Lowest Common Ancestor of a Binary Tree
// Time Complexity: O(n)
// Space Complexity: O(h)

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
        TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
            if (!root || root == p || root == q) {
                return root;
            }
    
            TreeNode* left = lowestCommonAncestor(root->left, p, q);
            TreeNode* right = lowestCommonAncestor(root->right, p, q);
    
            if (!left && !right) {
                return nullptr;
            } else if (!left) {
                return right;
            } else if (!right) {
                return left;
            } else {
                return root;
            }
        }
    };