

/*
// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Inorder traversal and choosing the kth element.
*/


#include<iostream>
#include<vector>

using namespace std;

typedef struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x),left(nullptr),right(nullptr){}
}TreeNode;

class Solution {
    int sol{};
    int cnt{};
    void dfs(TreeNode* root,int k){
        //base
        if(root == NULL) return;
        
        //logic
        if(!sol) dfs(root->left,k);
        //cout<<"root val "<<root->val<<endl;
        cnt++;
        if(k == cnt){
            sol = root->val;
            return;
        }
        if(!sol) dfs(root->right,k);
    }

public:
    int kthSmallest(TreeNode* root, int k) {
        //cout<<"inorder Traversal "<<endl;
        dfs(root,k);
        return sol;
    }
};