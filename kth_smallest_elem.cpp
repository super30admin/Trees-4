//Time O(n)
 //Space O(n)
 //Leetcode : yes
 //Issue seen: none
class Solution {
public:
int count =0;
    void inorder(TreeNode* root, int k, int &val){
        if(!root) return;
        
        inorder(root->left,k, val);
        count++;
        if(count == k){
            val = root->val;
            return;
        }
        inorder(root->right, k, val);
    

    }
    int kthSmallest(TreeNode* root, int k) {
        int val=0;
        inorder(root, k, val);
        return val;
        
    }
};
