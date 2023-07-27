// Time Complexity : O(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
  
using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    int count = 0; // Variable to keep track of the count while traversing nodes
    int res = -1; // Variable to store the k-th smallest element

    int kthSmallest(TreeNode* root, int k) {
        inorder(root, k); // Call the helper method to find the k-th smallest element
        return res; // Return the result
    }

    void inorder(TreeNode* root, int k) {
        if (root == nullptr) {
            return; // Base case: if the current node is null, return
        }

        inorder(root->left, k); // Recursively traverse left subtree

        count++; // Increment the count for the current node

        if (count == k) { // If the count matches k, we found the k-th smallest element
            res = root->val; // Update the result variable with the current node's value
            return; // No need to continue traversal once we found the result
        }

        if (count < k) { // If count is less than k, continue traversing the right subtree
            inorder(root->right, k);
        }
    }
};
