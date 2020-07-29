//Space Comp: O(N)
//Time Comp: O(N)

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
int i = 0;
private:
    void inorder(TreeNode* root, int k, int& result){
        if(root == nullptr) return ;
        inorder(root->left, k, result);
        i++;
        if(k==i) result = root->val;
        inorder(root->right,k, result);
    }
public:
    int kthSmallest(TreeNode* root, int k) {
        int result = 0;
        inorder(root,k,result);
        return result;
    }
};