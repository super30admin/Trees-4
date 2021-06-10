/*
Intuition: The ancestor should be greater than left and lesser than right
#####################################################################
Solution 1: Recursive
Time Complexity : O(H) 
Space Complexity : O(H)
#####################################################################
Solution 2: Iterative
Time Complexity : O(N) 
Space Complexity : O(1)

*/
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode * curr = root;
        if ( p->val > q->val) return lowestCommonAncestor(root, q, p);
        while( curr != NULL){
            
            if ( curr->val >  p->val and curr->val >  q->val) curr =  curr->left;
            else if ( curr->val <  p->val and curr->val  <  q->val) curr = curr->right;
            else{
                return curr;
            }
        }
        return curr;
        
    }
};

class Solution {
public:
    TreeNode* result = NULL;
    TreeNode* lowestCommonAncestor(TreeNode* curr, TreeNode* p, TreeNode* q) {
        if ( curr->val > p->val and curr->val> q->val) lowestCommonAncestor(curr->left, p, q) ;
        else if (curr->val< p->val and curr->val < q->val) lowestCommonAncestor(curr->right, p, q);
        else{
            result = curr;
            return result;
        }return result;

    }
};