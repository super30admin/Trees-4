//Time - O(N)
//Space - O(h) - h height of BST
class Solution {
public:
    int s = 0;
    int kthSmallest(TreeNode* root, int k) {
        findKthSmallest(root,k);
        return s;
    }
    void findKthSmallest(TreeNode* root,int& k){
        if(root==0) return;
        
        findKthSmallest(root->left,k);
        k--;
        if(k==0) s = root->val;
        findKthSmallest(root->right,k);
    }
};