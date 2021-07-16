// Time Complexity : O(n) 
// Space Complexity : O(n) stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// LCA of Binary Tree

#include<vector>
#include<iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class Solution {
    vector<TreeNode*> path1;
    vector<TreeNode*> path2;
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL)
            return root;
        
        vector<TreeNode*> path;
        backtrack(root, p, q, path);
        // return ancestor
        for(int i = 0; i < path1.size(); i++){
            if(path1[i] != path2[i])
                return path1[i-1];
        }
        return NULL;
    }
    
    void backtrack(TreeNode* root, TreeNode* p, TreeNode* q, vector<TreeNode*>& path){
        // base
        if(root == NULL)
            return;
        
        path.push_back(root);
        
        if(root == p){  
            path1 = path;
            path1.push_back(root);
        }
        
        if(root == q){
            path2 = path;
            path2.push_back(root);
        }
        
        // logic
        
        backtrack(root->left, p, q, path);
        backtrack(root->right, p, q, path);
        path.pop_back();
    }
};