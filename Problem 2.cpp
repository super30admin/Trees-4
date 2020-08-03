//Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    //recursive solution
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        //if(root==NULL) return NULL;
        
        if(root->val > p->val && root->val >q->val) 
            return lowestCommonAncestor(root->left, p, q);
        
        else if(root->val < p->val && root->val < q->val)
            return lowestCommonAncestor(root->right, p , q);
        
        return root;
    }
};

        