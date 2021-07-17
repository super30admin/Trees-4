// Time Complexity : O(k)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
private:
    int count = 0;
    int ret_val = -1;

    // Recursive function for pre order traversal    
    void pre_order_rec(TreeNode* root, int k)
    {
        // Null root condition
        if(root == NULL)
            return;
        
        // Traverse the left subtree
        if(root->left)
            pre_order_rec(root->left, k);
        
        // Increment the count of nodes viited
        count++;
        // Stop when kth node is visited
        if(count == k)
        {
            ret_val = root->val;
            return;
        }
        
        // Traverse the right subtree
        if(root->right)
            pre_order_rec(root->right, k);
    }
    
public:
    int kthSmallest(TreeNode* root, int k) {

        // Start pre order traversal and stop at kth smallest element       
        pre_order_rec(root, k);
        
        return ret_val;
    }
};