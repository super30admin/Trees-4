//Time - O(N)
//Space - O(h)
class Solution {
public:
    TreeNode* lca = NULL;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
      if(root == NULL) return NULL; 
        
      return findLowestCommonAncestor(root,p,q);
    }
    
    TreeNode* findLowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q){
        if(root == NULL || root->val == p->val || root->val == q->val) return root;
        
        TreeNode* left = findLowestCommonAncestor(root->left, p,q);
        TreeNode* right= findLowestCommonAncestor(root->right, p,q);
        
        
        if(left && right) return root;
        return left==NULL ? right: left;

    }
};