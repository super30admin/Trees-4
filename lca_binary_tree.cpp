//Time O(n)
 //Space O(n)
 //Leetcode: yes
 //issue seen: none
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root) return root;
        
        if(p->val == root->val || q->val == root->val){
            return root;
        }
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        if(left && right){
            return root;
        } else if(!left && right){
            return right;
        } else {
            return left;
        }

        
    }
};
