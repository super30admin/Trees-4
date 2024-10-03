//time: O(n) space: O(1)
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