// Time Complexity : O(h)
// Space Complexity : O(h)
//    where h : Height of tree.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Traverse the tree using following three conditions :- 
 *  1) If p and q are smaller than current node value then go to the left side of tree.
 *  2) If p and q are greater than current node value then go to the right side of tree.
 *  3) If both above conditions are not true then return current node.
 */

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
        if (root == nullptr)
            return nullptr;
        
        if (root->val > p->val && root->val > q->val)
            return lowestCommonAncestor(root->left, p, q);
        
        if (root->val < p->val && root->val < q->val)
            return lowestCommonAncestor(root->right, p, q);
        
        return root;
    }
};