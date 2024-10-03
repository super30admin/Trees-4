//time: O(logn) space: O(1)
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* result;
        helper(root, p, q, result);
        return result;
    }
private:
    void helper(TreeNode* root, TreeNode* p, TreeNode* q, TreeNode* &result) {
        if(root == NULL) {
            return;
        }
        else if(root->val > p->val && root->val > q->val) {
            helper(root->left, p, q, result);
        }
        else if(root->val < p->val && root->val < q->val) {
            helper(root->right, p, q, result);
        }
        else {
            result = root;
            return;
        }
    }
};