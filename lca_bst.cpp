// Time complexity: O(h) where h is the height of the tree
// Space complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes

// Approach:
// - If both p and q are less than the root, then the LCA lies in the left subtree.
// - If both p and q are greater than the root, then the LCA lies in the right subtree.
// - If one of the nodes is less than the root and the other is greater than the root, then the root is the LCA.


class Solution {
    public:
        TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
            if(root == nullptr){
                return root;
            }
    
            if(p -> val < root -> val && q -> val < root -> val){
                return lowestCommonAncestor(root -> left, p, q);
            }
            else if(p -> val > root -> val && q -> val > root -> val){
                return lowestCommonAncestor(root -> right, p, q);
            }
            else{
                return root;
            }
        }
    };