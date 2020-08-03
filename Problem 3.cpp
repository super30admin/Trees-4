//Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root==NULL|| root->val==p->val || root->val==q->val)
            return root;
        TreeNode* l = lowestCommonAncestor(root->left, p,q);
        TreeNode* r = lowestCommonAncestor(root->right, p, q);
        
        if(l!=NULL && r!=NULL) return root;
        
        else if(l!=NULL)
            return l;
        else if(r!=NULL)
            return r;
        
        return NULL;
        
    }
};