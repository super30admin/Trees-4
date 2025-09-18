#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
struct TreeNode {
public:
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
/*
We keep moving left when p and q both are smaller than root
We go right if both are greater than root
The moment they split up, or one matches root thats our LCA
*/
class Solution{
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q){
        if(p->val < root->val && q->val < root->val) return lowestCommonAncestor(root->left, p, q);
        else if(p->val > root->val && q->val > root->val) return lowestCommonAncestor(root->right, p, q);
        else return root;
    }
};
