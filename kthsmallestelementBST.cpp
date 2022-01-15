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

//Time complexity : O(n)
//Space complexity : O(n)

class Solution {
public:
    int count, result;
    int kthSmallest(TreeNode* root, int k) {
        if(root == nullptr)
            return -1;
        
        count = k;
        result = -1;
        
        inorder(root);
        
        return result;
    }
    
    void inorder(TreeNode* root)
    {
        if(root == nullptr || count < 0)
            return;
        
        inorder(root->left);
        
        count--;
        if(count == 0)
        {
            result = root->val;
            return;
        }
        
        inorder(root->right);
    }
};