#include<bits/stdc++.h>
using namespace std;

/*
Approach: Do inorder traversal and keep track of the kth element
Time: O(n)
Space: O(h).. recursive stack
Working on leetcode: Yes
*/

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    int count,ans;
    int kthSmallest(TreeNode* root, int k) {
        ans = -1;
        count = 1;
        inorder(root, k);
    }

    void inorder(TreeNode* root, int k) {
        if(root == nullptr) {
            return;
        }

        inorder(root->left, k);

        if(k == count) {
            ans = root->val;
        }
        count++;

        inorder(root->right, k);
    }
};