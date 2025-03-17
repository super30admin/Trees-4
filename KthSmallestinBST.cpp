// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
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
    int res = 0;
    void inorder(TreeNode* root, int& count, int k){
        if (root == nullptr) return;
        inorder(root->left, count, k);
        count--;
        if (count == 0) {
            res = root->val;
            return;}
        inorder(root->right, count, k);
    }
     int kthSmallest(TreeNode* root, int k) {
        int count = k;
        // int res =0;
         inorder(root, count, k);
         return res;
    }
};