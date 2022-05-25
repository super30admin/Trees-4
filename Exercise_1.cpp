/* 
    Time Complexity                              :  O(N)
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std; 

// https://leetcode.com/problems/kth-smallest-element-in-a-bst

class Solution {
private:
    int ans;int ks;
public:
    int kthSmallest(TreeNode* root, int k) {
        ks = k;
        ans = -1;
        inorder(root);
        return ans;
    }
    
    void inorder(TreeNode *root) {
        if(!root) return;
        
        inorder(root->left);
        ks--;
        if(ks==0) {
            ans = root->val;
            return;
        }
        if(ans >= 0) return;
        inorder(root->right);
    } 
};