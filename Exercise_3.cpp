/* 
    Time Complexity                              :  O(N)
    Space Complexity                             :  Recursive Approach - O(N) when the tree is skewed
                                                    Backtracking - O(H + H + H + H) 
                                                    Memory consumed due to the recursion stack and 
                                                    memory due to the pathP, pathQ and path.
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/


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
private:
    
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        return recursive(root, p, q);
        // vector<TreeNode*> pathQ;
        // vector<TreeNode*> pathP;
        // backtracking(root, p, q, vector<TreeNode*>(), pathP, pathQ);
        // for(int i=0;i<pathP.size();i++) {
        //     if(pathP[i] != pathQ[i]) {
        //         return pathP[i-1];
        //     }
        // }
        // return NULL;
    }
    
    TreeNode* recursive(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL or root == p or root == q) return root;
        TreeNode *ra = lowestCommonAncestor(root->right,p,q), *la = lowestCommonAncestor(root->left, p, q);
        if(la and ra) return root;
        return la?la:ra;
    }
    
    // memory limit exceeded
    void backtracking(TreeNode* root, TreeNode* p, TreeNode* q, vector<TreeNode*> path, vector<TreeNode*>& pathP, vector<TreeNode*>& pathQ) {
        if(!root) return;
        
        path.push_back(root);
        if(root == p) {
            pathP = path;
            pathP.push_back(root);
        }
        
        if(root == q) {
            pathQ = path;
            pathQ.push_back(root);
        }
        
        backtracking(root->left, p, q, path, pathP, pathQ);
        backtracking(root->right, p, q, path, pathP, pathQ);
        
        path.pop_back();
    }
};