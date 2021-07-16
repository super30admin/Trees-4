// Time Complexity : O(h) height of the tree
// Space Complexity : O(h) recursive stack size, O(1) Constant for iterative
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// LCA of BST

#include<vector>
#include<iostream>

using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

// Recursive

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
 
        if(root->val < p->val && root->val < q->val)
            return lowestCommonAncestor(root->right, p, q);
        
        else if(root->val > p->val && root->val > q->val)
            return lowestCommonAncestor(root->left, p, q);
        else
            return root;
    }
};


// Iterative

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        while(true){
          if(root->val < p->val && root->val < q->val)
              root = root->right;
          else if(root->val > p->val && root->val > q->val)
              root = root->left;
          else
              return root;
        }
    }
};