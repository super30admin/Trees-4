// Time complexity: O(n) where n is the number of nodes in the tree
// Space complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes

// Approach:
// - If the root is null, return null.
// - If the root is equal to p or q, return the root.
// - Recursively find the LCA in the left and right subtrees.
// - If both left and right subtrees return a non-null value, then the root is the LCA.
// - If only one of the subtrees returns a non-null value, then that subtree's value is the LCA.

class Solution {
    public:
        TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
            if(root == nullptr){
                return nullptr;
            }
            if(root == p || root == q){
                return root;
            }
            TreeNode* left = lowestCommonAncestor(root -> left, p, q);
            TreeNode* right = lowestCommonAncestor(root -> right, p, q);
    
            if(left != nullptr && right != nullptr){
                return root; 
            }
            else if(left != nullptr && right == nullptr){
                return left;
            }
            else{return right;}
            return nullptr;
        }
    };