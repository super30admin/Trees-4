//Time Complexity O(n)
// Space Complexity O(h)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;


  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
public:
    vector<TreeNode*> pathP;
    vector<TreeNode*> pathQ;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> path;
        dfs(root,p->val,q->val,path);
        
        int i=0;
        while(i<pathP.size())
        {
            if(pathP[i]->val != pathQ[i]->val)
            {
                if(i==0)
                    return root;
                else
                    return pathP[i-1];
            }
            i++;
        }
        return root;
    }
    
    void dfs(TreeNode* root, int p, int q, vector<TreeNode*>& path)
    {
        //base
        if(root==NULL) return;
        
        
        
        //Logic
        path.push_back(root);
        if(root->val==p)
        {
            pathP = path;
            pathP.push_back(root);
        }
        if(root->val==q)
        {
            pathQ=path;
            pathQ.push_back(root);
        }
        
        dfs(root->left,p,q,path);
        dfs(root->right,p,q,path);
        path.pop_back();
    }
};