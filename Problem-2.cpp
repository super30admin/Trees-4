// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


 class Solution {
    public:
        TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
            if(root == NULL) return NULL;
            if(root->val > p->val && root->val > q->val) return lowestCommonAncestor(root->left,p,q);
            else if(root->val < p->val && root->val < q->val) return lowestCommonAncestor(root->right,p,q);
            else return root;
    
        }
    };


// Non-recursive approach
// Time Complexity : O(h)
// Space Complexity : O(1)
 class Solution {
    public:
        TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
            if(root == NULL) return NULL;
            while(true){
                if(root->val > p->val && root->val > q->val) root = root->left;
                else if(root->val < p->val && root->val < q->val) root = root->right;
                else return root;
            }
            
    
        }
    };