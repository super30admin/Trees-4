// Time Complexity : O(n)
// Space Complexity : O(1)

Class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
          if(root==NULL){
            return NULL;
        }
        if(root==p||root==q){
            return root;
        }
       TreeNode* left =  lowestCommonAncestor(root->left,p,q);
       TreeNode* right = lowestCommonAncestor(root->right,p,q);

        if(left && right){
            return root;
        }
        else if(left && right==NULL){
            return left;
        }
 else if(right && left==NULL){
            return right;
        }
        else{
            return NULL;
        }
    }
};