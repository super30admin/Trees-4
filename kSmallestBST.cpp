// Time Complexity :O(n) where n in the number of nodes in a tree
// Space Complexity : O(H)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    int ans = -1,count=0;
public:
    int kthSmallest(TreeNode* root, int k) {
        inorder(root,k);
        return ans;
    }
    void inorder(TreeNode* root,int k){
        if(!root) return;
        inorder(root->left,k);
        count++;
        if(count == k) ans = root->val;
        if(ans == -1) inorder(root->right,k);
    }
};