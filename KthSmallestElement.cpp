// Time Complexity : O(n)
// Space Complexity : O(h)
//    where h : Height of tree.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Perform inorder traversal using stack. 
 * For each pop operation decrement k. When k is equal to 0 then return current popped element.  
 */

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
    int kthSmallest(TreeNode* root, int k) {
        if (root == nullptr)
            return -1;
        
        stack<TreeNode*> st;
        
        while (root != nullptr || !st.empty())
        {
            while (root != nullptr)
            {
                st.push(root);
                root = root->left;
            }
            
            root = st.top();
            st.pop();
            k--;
            
            if (k == 0)
                return root->val;
            
            root = root->right;
        }
        return -1;
    }
};