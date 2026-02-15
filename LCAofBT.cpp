/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* answer=nullptr;

    bool helper(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == nullptr) {
            return false;
        }

        int left = (helper(root->left, p, q) ? 1 : 0);
        int right = (helper(root->right, p, q) ? 1 : 0);

        int rootIsNode = ((root == p || root == q) ? 1 : 0);

        if (left + right + rootIsNode == 2) {
            answer = root;
        }

        return ((left + right + rootIsNode) > 0);
    }
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == nullptr)
            return root;
        helper(root, p, q);
        return answer;
    }
};
