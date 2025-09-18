#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We check left and right subtrees recursively to find p and q.
If both left and right return non-null, current node is the LCA.
If only one side is non-null, return that side as it contains both or one target.
*/
struct TreeNode {
public:
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
class Solution{
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q){
        if(root == nullptr || root == p || root == q) return root;

        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);

        if(!left && !right) return nullptr;
        if(!left && right) return right;
        if(left && !right) return left;
        else return root;
    }
};
