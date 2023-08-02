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
        if(root == nullptr || root == p || root == q) return root; 

        TreeNode* leftTree = lowestCommonAncestor(root->left, p, q);
        TreeNode* rightTree = lowestCommonAncestor(root->right, p, q);    

        if(leftTree == nullptr && rightTree == nullptr) return nullptr; 
        else if(leftTree != nullptr && rightTree == nullptr) return leftTree; 
        else if(leftTree == nullptr && rightTree != nullptr) return rightTree; 

        return root; 
    }
};