//1. top bottom - maintaining path and comparing paths for p and q till common ancestors
//2. bottom up (most efficient)
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//bottom-up approach
//time: O(n)
//space: O(1)
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        return helper(root, p, q);
    }
private:
    TreeNode* helper(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL || root == p || root == q) {
            return root;
        }
        TreeNode* left = helper(root->left, p, q);
        TreeNode* right = helper(root->right, p, q);
        if(left == NULL && right == NULL) {
            return NULL;
        }
        else if(left != NULL && right != NULL) {
            return root;
        }
        else if(left != NULL) {
            return left;
        }
        else {
            return right;
        }
    }
};