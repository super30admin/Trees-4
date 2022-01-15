/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

//Time complexity : O(n)
//Space complexity : O(n)

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == nullptr || root == p || root == q)
            return root;
           
        TreeNode* left = lowestCommonAncestor(root->left, p , q);
        TreeNode* right = lowestCommonAncestor(root->right, p , q);
        
        if(left == nullptr && right == nullptr)
            return nullptr;
        else if(left == nullptr && right != nullptr)
            return right;
        else if(left != nullptr && right == nullptr)
            return left;
        else 
            return root;
    }
};