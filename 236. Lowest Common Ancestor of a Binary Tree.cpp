/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

/*

Time: O(n)
Space: O(logn)

The two nodes p and q will exist in different subtree for only one node -> that one is the lca!
*/

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root==nullptr)  return nullptr;
        if(root->val==p->val || root->val==q->val)  return root; //if current node is p or q, return it immidiately!

        TreeNode* leftFind = lowestCommonAncestor(root->left,p,q);
        TreeNode* rightFind = lowestCommonAncestor(root->right,p,q);

        if(leftFind!=nullptr && rightFind!=nullptr)  return root; //if p and q is in different subtrees, this node is the lca
        return leftFind != nullptr ? leftFind : rightFind; //otherwise return the p or q or none from its substrees
    }
};
