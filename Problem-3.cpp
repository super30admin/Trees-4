// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public:
        TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
            if(root == NULL || root == p || root == q) return root;
            TreeNode* left = lowestCommonAncestor(root->left, p, q);
            TreeNode* right = lowestCommonAncestor(root->right, p, q);
            if(left == NULL && right == NULL) return NULL;
            if(left != NULL && right == NULL) return left;
            if(left == NULL && right != NULL) return right;
            return root;
        }
    };