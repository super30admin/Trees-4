// Time Complexity : O(n)
// Space Complexity : O(h)
//    where h : Height of tree.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Traverse the tree using following conditions :- 
 *  1) If root value is equal to p or q then return root. 
 *  2) Traverse the left and right subtrees. 
 *  3) If both left and right subtree return valid pointer then return root else return not null right or left node.
 */

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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == nullptr || root == p || root == q)
            return root;
                
        TreeNode* left = lowestCommonAncestor(root->left, p , q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        
        if (left != nullptr && right != nullptr)
            return root;
        else if (left != nullptr && right == nullptr)
            return left;
        else if (left == nullptr && right != nullptr)
            return right;
        else 
            return nullptr;
    }
};