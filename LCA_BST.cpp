// Time Complexity : O(LogN) where N=Number of Nodes
// Space Complexity : O(1) For iterative, O(H) for Recursive
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        //Recursive Solution
        // if(root==NULL)
        //     return NULL;
        // if(p->val<root->val && q->val < root->val) return(lowestCommonAncestor(root->left,p,q));
        // else if(p->val > root->val && q->val > root->val) return(lowestCommonAncestor(root->right,p,q));
        // else return root;
        
        //Iterative Solution
        while(root!=NULL){
            if(p->val<root->val && q->val < root->val) root = root->left;
            else if(p->val > root->val && q->val > root->val) root = root->right;
            else 
                return root;
        }
        return NULL;
    }
};
