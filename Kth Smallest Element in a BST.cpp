//follow up: maintain left counts of all nodes
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
//time: O(n)
//space: O(1)
class Solution {
    int result;
    int count;
private:
    void inorder(TreeNode* root) {
        if(root == NULL || count <= 0) { // conditional recursion - conditions other than base case
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