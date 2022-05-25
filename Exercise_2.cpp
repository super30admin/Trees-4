/* 
    Time Complexity                              :  O(N) in both recursive and iterative methods
    Space Complexity                             :  O(1) in iterative and O(N) in recursive when 
                                                    the tree is skewed
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

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
        // if(root->val > p->val and root->val > q->val) {
        //     return lowestCommonAncestor(root->left, p, q);
        // } else if (root->val < p->val and root->val < q->val) {
        //     return lowestCommonAncestor(root->right, p, q);
        // } else {
        //     return root;
        // }
        
        // return lca(root, p, q);
        return iterative(root, p, q);
    }
    
    TreeNode* lca(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL or root == p or root == q) return root;
        TreeNode *ra = lca(root->right, p, q), *la = lca(root->left, p, q);
        if(la and ra) return root;
        return la?la:ra;
    }
    
    TreeNode* iterative(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        while(true) {
            if(root->val > p->val and root->val > q->val) {
                root = root->left;
            } else if (root->val < p->val and root->val < q->val) {
                root = root->right;
            } else {
                return root;
            }
        }
    }
};