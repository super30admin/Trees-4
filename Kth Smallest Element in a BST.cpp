//time: O(n) space: O(1)
class Solution {
    int result;
    int count;
private:
    void inorder(TreeNode* root) {
        if(root == NULL || count <= 0) {
            return;
        }
        inorder(root -> left);
        count--;
        if(count == 0) {
            result = root -> val;
        }
        inorder(root -> right);
    }
    
public:
    int kthSmallest(TreeNode* root, int k) {
        count = k;
        inorder(root);
        return result;
    }
};