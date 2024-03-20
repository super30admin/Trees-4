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
    /*
    Time: O(logn)
    Space: O(logn)

    In a bst top-down traverse,
    - if the 2 nodes fall in different sides of the current node, current node is the LCA
    - else the LCA will be in the side where the 2 nodes fall (so we can prune one half)
    */
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root==nullptr)  return nullptr;

        int b = max(p->val, q->val), s = min(p->val, q->val);
        
        if(root->val >= s && root->val <= b)  return root; //lca found!
        else if(b > root->val)  return lowestCommonAncestor(root->right,p,q); //prune left half
        else  return lowestCommonAncestor(root->left,p,q); //prune right half
    }
};