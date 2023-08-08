// Time Complexity : O(log(n))
// Space Complexity : O(1)


class Solution {
public:
int curr=-1;
int count=0;
void inorder(TreeNode* root, int k){
if(root==NULL){
    return;
}
if(count>=k){
    return;
}

    inorder(root->left,k);
    if(count<k){
    curr=root->val;
count++;
}
   inorder(root->right,k);

}
    int kthSmallest(TreeNode* root, int k) {

        inorder(root,k);
        return curr;
    }
};