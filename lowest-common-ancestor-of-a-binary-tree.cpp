// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> path1, path2;

        backtrack(root, p, path1);
        backtrack(root, q, path2);

        int i = 0;
        while (i < path1.size() && i < path2.size() && path1[i] == path2[i]) {
            i++;
        }

        return path1[i - 1];
    }

    void backtrack(TreeNode* root, TreeNode* target, vector<TreeNode*>& path) {
        if (root == nullptr) return;

        if (root == target) {
            path.push_back(root);
            return;
        }

        path.push_back(root);

        backtrack(root->left, target, path);
        if (path.back() == target) return;

        backtrack(root->right, target, path);
        if (path.back() == target) return;

        path.pop_back();
    }
};
