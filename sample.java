// Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
public:
int curr=-1;
int count=0;
void inorder(TreeNode* root, int k){
if(root==NULL){
    return;
}
if(count>=k){
    return;
}

    inorder(root->left,k);
    if(count<k){
    curr=root->val;
count++;
}
   inorder(root->right,k);

}
    int kthSmallest(TreeNode* root, int k) {

        inorder(root,k);
        return curr;
    }
};


// Problem2: Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
public:


    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root==NULL){
            return NULL;
        }
        if(root==p||root==q){
            return root;
        }
       TreeNode* left =  lowestCommonAncestor(root->left,p,q);
       TreeNode* right = lowestCommonAncestor(root->right,p,q);
     
        if(left && right){
            return root;
        }
        else if(left && right==NULL){
            return left;
        }
 else if(right && left==NULL){
            return right;
        }
        else{
            return NULL;
        }
    }
    
};


// Problem3: Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

Class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
          if(root==NULL){
            return NULL;
        }
        if(root==p||root==q){
            return root;
        }
       TreeNode* left =  lowestCommonAncestor(root->left,p,q);
       TreeNode* right = lowestCommonAncestor(root->right,p,q);
     
        if(left && right){
            return root;
        }
        else if(left && right==NULL){
            return left;
        }
 else if(right && left==NULL){
            return right;
        }
        else{
            return NULL;
        }
    }
};