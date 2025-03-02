// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Kth Smallest Element in a BST
// Approach: Trversal
// Time Complexity: O(h + k)
// Space Complexity: O(h)

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

 class Solution {
    public:
        int kthSmallest(TreeNode* root, int k) {
            std::stack<TreeNode*> s;
            
            while (true) {
                while (root) {
                    s.push(root);
                    root = root->left;
                }
                
                root = s.top();
                s.pop();
                
                if (--k == 0) {
                    return root->val;
                }
                
                root = root->right;
            }
        }
    };