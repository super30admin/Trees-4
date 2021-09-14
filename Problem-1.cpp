/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 RECURSIVE
 Time Complexity = O(h)
 Space Complexity = O(h)
 where h is the height of the tree.
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root->val > p->val && root->val > q->val)
            return lowestCommonAncestor(root->left,p,q);
        else if(root->val < p->val && root->val < q->val)
            return lowestCommonAncestor(root->right,p,q);
        else
            return root;
    }
};

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 Iterative
 Time Complexity = O(h)
 Space Complexity = O(1)
 where h is the height of the tree.
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        while(true){
            if(root->val >p->val && root->val >q->val)
                root=root->left;
            else if(root->val <p->val && root->val <q->val)
                root=root->right;
            else 
                return root;
        }
    }
};
