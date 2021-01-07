//Time - O(N)
//Space - O(1)
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL) return NULL; 
        
        while(root){
            if(p->val < root->val && q->val < root->val){
                root = root->left;
            }else if(p->val > root->val && q->val > root->val){
                root = root->right;
            }else{
                return root;
            }
        }
        
        return NULL;
        
    }
    
};