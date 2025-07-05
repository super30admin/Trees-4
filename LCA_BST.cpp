//Time Complexity : O(h)
//Space Complexity : O(h)
#include<iostream>
#include<vector>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root==nullptr)
            return nullptr;
        if((root->val > p->val) && (root->val > q->val)){
            return lowestCommonAncestor(root->left,p,q);
        }
        if((root->val < p->val) && (root->val < q->val)){
            return lowestCommonAncestor(root->right,p,q);
        }
        return root;
    }
};