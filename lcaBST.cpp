// Time Complexity :O(n) where n in the number of nodes in a tree
// Space Complexity : O(H)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        if(root->val > max(p->val,q->val)) return lowestCommonAncestor(root->left,p,q);
        else if(root->val < min(p->val,q->val)) return lowestCommonAncestor(root->right,p,q);
        return root;
    }
};