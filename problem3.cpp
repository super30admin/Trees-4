
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Time Complexity : O(n+h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
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
    vector<TreeNode*>pathP;
    vector<TreeNode*>pathQ;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*>currPath;
        dfs(root,p,q,currPath);
        for(int i = 1;i<pathP.size();i++){
            if(pathP[i]!=pathQ[i]){
                return pathP[i-1];
            }
        }
        return NULL;
    }
    void dfs(TreeNode* root, TreeNode* p, TreeNode* q,vector<TreeNode*>&currPath)
    {
        if(root==NULL) return;
        
        currPath.push_back(root);
        if(root==p){
            pathP = currPath;
            pathP.push_back(pathP[pathP.size()-1]);
        }
        if(root==q){
            pathQ = currPath;
            pathQ.push_back(pathQ[pathQ.size()-1]);
        }
        dfs(root->left,p,q,currPath);
        dfs(root->right,p,q,currPath);
        currPath.pop_back();
    }
};


// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes

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
        if(root == NULL || root==p || root==q) return root;
        TreeNode* left = lowestCommonAncestor(root->left,p,q);
        TreeNode* right = lowestCommonAncestor(root->right,p,q);
        if(left==NULL && right==NULL) return NULL;
        if(left!=NULL && right == NULL) return left;
        if(left==NULL && right!=NULL) return right;
        return root;
    }
};