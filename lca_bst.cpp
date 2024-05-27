//Time O(n)
//Space O(n)
//Leetcode: yes
//Issue seen: none
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root) return NULL;
        if(!p && !q) return root;
        if(root->val > p->val && root->val > q->val){
            return lowestCommonAncestor(root->left, p , q);
        } else if(root->val < p->val && root->val < q->val){
            return lowestCommonAncestor(root->right, p , q);
        } else {
            return root;
        }
        
    }
};
