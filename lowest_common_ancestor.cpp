//Time Complexity-O(n)
//Space Complexity-O(h)
//Ran successfully on leetcode
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
        if(root==NULL)
            return NULL;
		//If p and q and lesser than root, then we move right
        if(p->val>root->val&&q->val>root->val)
            return lowestCommonAncestor(root->right,p,q);
		//If p and q and lesser than root, then we move left   
		if(p->val<root->val&&q->val<root->val)
            return lowestCommonAncestor(root->left,p,q);
		//Else, it will be the root
        return root;
    }
};