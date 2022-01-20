//Time Complexity O(n)
// Space Complexity O(h)(Height of the tree)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
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
 
class Solution {
public:
    int total;
    int ele=0;
    int kthSmallest(TreeNode* root, int k) {
        total=k;
        inorder(root);
        return ele;
    }
    
    void inorder(TreeNode* root)
    {
        if(root==NULL)
        {
            return;
        }
        inorder(root->left);
        total--;
        if(total==0)
        {
            ele=root->val;
            return;
        }
        inorder(root->right);
    }
};