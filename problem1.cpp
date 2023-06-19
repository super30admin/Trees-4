// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
public:
    int cnt = 0;
    int ans = -1;
    int kthSmallest(TreeNode* root, int k) {
        if(root==NULL || ans!=-1) return 0;
        kthSmallest(root->left,k);
        cnt++;
        if(cnt == k){
            ans = root->val;
            return ans;
        }
        kthSmallest(root->right,k);
        return ans;
    }
};
