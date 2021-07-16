// Time Complexity : O(n) 
// Space Complexity : O(n) recursive stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// Kth Smallest element in a BST

#include<vector>
#include<iostream>
#include<stack>

using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


// Recursive

class Solution {
    int result;
    int count = 0;
public:
    int kthSmallest(TreeNode* root, int k) {
        
        if(root == NULL)
            return 0;
        
        inorder(root, k);
        return result;
    }
    
    void inorder(TreeNode* root, int k){
        //  base
        if(root == NULL)
            return;
        
        // logic
        inorder(root->left, k);
        
        ++count;
        if(count == k){
            result = root->val;
            return;
        }
        inorder(root->right, k);
    }
};

// Iterative

class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        stack<TreeNode*> s1;
        while(root != NULL || !s1.empty()){
            while(root != NULL){
                s1.push(root);
                root = root->left;
            }
            root = s1.top();
            s1.pop();
            k--;
            if(k == 0)
                return root->val;
            root = root->right;
        }
        
        return 0;
    }
};