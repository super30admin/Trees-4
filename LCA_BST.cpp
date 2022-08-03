// Recursive Solution
// Time Complexity - O(logn)
// Space Complexity - Recursive stack space - O(h)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(p->val > root->val && q->val > root->val)
            return lowestCommonAncestor(root->right, p, q);
        else if(p->val < root->val && q->val < root->val)
            return lowestCommonAncestor(root->left, p, q);
        else
            return root;
    }
};

// Iterative Solution
// Time Complexity - O(logn)
// Space Complexity - O(1)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        while(true){
            if(p->val > root->val && q->val > root->val)
            root = root->right;
        else if(p->val < root->val && q->val < root->val)
            root = root->left;
        else
            return root;
        }
    }
};