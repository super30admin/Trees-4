// Time Complexity : O(N) where N=Number of Nodes
// Space Complexity : O(H) H->height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Implemented using recursive approach

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root==NULL || p->val == root->val || q->val == root->val) return root;
        
        TreeNode* left = lowestCommonAncestor(root->left,p,q);
        TreeNode* right =lowestCommonAncestor(root->right,p,q);
        if(left!=NULL && right!=NULL) return root;
        else if(left!=NULL) return left;
        else if(right !=NULL ) return right;
        else return NULL;
        
        
    }
};
