// Time complexity: O(n) where n is the number of nodes in the tree
// Space complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes

// Approach:
// - Perform an inorder traversal of the BST and keep track of the count of nodes visited.
// - When the count becomes equal to k, return the value of the node.

class Solution {
    int count = 0;
public:
    int kthSmallest(TreeNode* root, int k) {
        int result = -1; 
        inorder(root, k, result);
        return result;
    }

    void inorder(TreeNode* root, int k, int& result){
        if(root == nullptr){
            return;
        }
        inorder(root -> left, k, result);
        count++;
        if(count == k){
            result = root -> val;
            return;
        }
        inorder(root -> right, k, result);
    }
};