#include<iostream>
#include<bits/stdc++.h>
#include<vector>
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
/*
We use stack to first put the root into the stack while root is not nullt and stack is not empty
then we again check while root is not null we push the root into the stack and we decrement k accordingly
and check if k is 0 then we return the value of the root else we return -1
*/
class Solution{
public:
    int kthSmallest(TreeNode* root, int k){
        stack<TreeNode*> st;
        while(root || !st.empty()){
            while(root){
                st.push(root);
                root = root->left;
            }
            root = st.top(); st.pop();

            k--;
            if(k == 0) return root->val;

            root = root->right;
        }
        return -1;
    }
};
