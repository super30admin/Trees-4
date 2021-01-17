// ## Problem1 Kth Smallest Element in a BST 
// (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

//Recursive
//TC-O(h+k)
//SC-O(h)

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
public:
    int ans;
    int kthSmallest(TreeNode* root, int k) {
        if(root==NULL){
            return -1;
        }
        
        int cnt= 0;
        int flag= 0;
        inorder(root, k, cnt, flag);
        return ans;
    }
    
    void inorder(TreeNode* root, int k , int &ctr, int &flag){
        
        if(root==NULL || flag==1){ //flag for controlled recursion
            return;
        }
        
        // cout<<" ---" << root->val << "--" << k << "---" << ctr<<endl;
        
        inorder(root->left, k ,ctr, flag);
        ctr++; // increment count as processing current node 
        if(k==ctr){
            flag=1;
            ans= root->val;
            return;
        }
        inorder(root->right, k, ctr,flag);
    }
};


//Iterative
//TO DO :::    - code is not working -pls tell the error
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
public:

    int kthSmallest(TreeNode* root, int k) {
        if(root==NULL){
            return -1;
        }
     
        stack<TreeNode*> s1;
        
        while(root!=NULL || !s1.empty()){
            
            while(root!= NULL){
                s1.push(root);
                root= root->left;
            }
            
            TreeNode* root = s1.top();
          
            s1.pop();
            k--;
            if(k==0){
                return root->val;
            }
            root= root->right;
         
            
        }
       return -1; 
    }
    
   
};