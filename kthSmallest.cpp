// Approach 1 : Preorder traversal

// Time Complexity : O(h) height of the stree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

/*
Preorder returns numbers in ascending order 
get that and return the number at k-1
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
    vector<int> result;
public:
    int kthSmallest(TreeNode* root, int k) {
        // preorder traversal should retrun the numbers in ascending order
        preorder(root);
        return result[k-1];
    }

private:
    void preorder(TreeNode* root){
        if(root == NULL) return;
        preorder(root->left);
        result.push_back(root->val);
        preorder(root->right);
    }
};

// Approach 2: Keep a counter instead of storing the result and return as soon as you hit the kth number
// Time: same asymptotically but slightly better since we only traverse till k

class Solution {
    int counter;
    int result;
public:
    int kthSmallest(TreeNode* root, int k) {
        counter = 0;
        preorder(root, k);
        return result;
    }

private:
    void preorder(TreeNode* root, int k){
        if(root == NULL) return;
        preorder(root->left, k);
        counter++;
        if(counter == k){
            result = root->val;
            return;
        }
        preorder(root->right, k);
    }
};