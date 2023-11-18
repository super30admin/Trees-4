#include<bits/stdc++.h>
using namespace std;

/*
Approach: BST property: If at root p and q both are less than root then the lca exists in left subtree. If both are greater then in right subtree. If root = p or q then root is the lca. If p>root but q<root and vice versa then also root is the lca
Time: O(h)
Space: O(h) .. recursive stack
Works on leetcode: Yes
*/

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
    TreeNode* lca;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        lca = nullptr;
        preorder(root, p, q);
        return lca;
    }

    void preorder(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == nullptr || lca != nullptr) {
            return;
        }

        if(root == p || root == q) {
            lca = root;
            return;
        }

        if((root->val>p->val && root->val<q->val) || (root->val<p->val && root->val>q->val)) {
            lca = root;
            return;
        }
        if(root->val>p->val) {
            preorder(root->left, p, q);
        }
        else {
            preorder(root->right, p, q);
        }
    }
};