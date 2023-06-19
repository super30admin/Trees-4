// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
    TreeNode* ans = NULL;
    void dfs(TreeNode* root, TreeNode* p, TreeNode* q)
    {
        if(root==NULL) return;
        if(p->val > root->val && q->val > root->val){
            dfs(root->right,p,q);
        }
        else if(p->val < root->val && q->val < root->val){
            dfs(root->left,p,q);
        }
        else {
            ans = root;
        }
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        dfs(root,p,q);
        return ans;
    }
};