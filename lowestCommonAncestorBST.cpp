// Approach 1 : Recursive

// Time Complexity : O(h) internal stack uses space = height of tree 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

// Approach 2: Iterative

// Time Complexity : O(h) internal stack uses space = height of tree 
// Space Complexity : O(1)

// Approach 1 : Recursive

/*
By the property of BST, the LCA will be such that p <= LCA <= q
recursively look for the node that satisfies this property and return the root
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
    TreeNode* result;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL) return NULL;

        if(root->val > p->val && root->val > q->val)
            return lowestCommonAncestor(root->left, p, q);
        
        if(root->val < p->val && root->val < q->val)
            return lowestCommonAncestor(root->right, p, q);
 
        return root;
    }
};

// Approach 2: Iterative

// Time Complexity : O(h) internal stack uses space = height of tree 
// Space Complexity : O(1)

class Solution {
public:
    TreeNode* result;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL ) return NULL;

        while(root != NULL) {
            if(root->val > p->val && root->val > q->val)
                root = root->left;
            else if (root->val < p->val && root->val < q->val)
                root = root->right;
            else
                return root;
        }
        return root;
    }
};