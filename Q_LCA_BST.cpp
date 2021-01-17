
// ## Problem2 Lowest Common Ancestor of a Binary Search Tree 
// (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

//recursive
//TC- O(h) h is height of tree
//SC - O(h) h is height of tree

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
        if(root==NULL){
            return root;
        }
        if(p->val < root->val && q->val < root->val ){
            return lowestCommonAncestor(root->left, p,q);
        }
        if(p->val > root->val && q->val > root->val ){
            return lowestCommonAncestor(root->right, p,q);
        } 
        else{
            return root;
        }
        
        
    }
};


//iterative
//TC- O(h) h is height of tree
//SC- O(1) as no extra space used

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
        if(root==NULL){
            return root;
        }
        while(true){
             if(p->val < root->val && q->val < root->val ){
                 root= root->left;
             }
            else if(p->val > root->val && q->val > root->val ){
                root= root->right;
            }
            else{
                return root;
            }
            
        }    
        
    }
};