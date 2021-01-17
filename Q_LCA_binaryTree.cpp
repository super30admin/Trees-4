
// ## Problem3 Lowest Common Ancestor of a Binary Tree
//  (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/


//TC- O(n)
//SC- O(n)
//Idea- store both paths into 2 list and compare each of the values in the list


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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        if(root==NULL){
            return root;
        }
        vector<TreeNode*> path1;
        vector<TreeNode*> path2;
        int flag =0; //flag to check if found path or not
        helper(root, p, path1, flag);
        flag =0;
        helper(root, q, path2, flag);
        // for(int i=0; i< path2.size(); i++){
        //     cout<< path2[i]->val << endl;
        // }
       // iterate over smaller path
        int i;
        for(i=0; i< min(path1.size(), path2.size()) ; i++){
            if( path1[i] != path2[i]){
                break;
            }
        }
        return path1[i-1];
       
    }
    
    void helper(TreeNode* root, TreeNode* p, vector<TreeNode*> &path, int &flag){
        // if(root !=NULL){
        //     cout<< root->val << " " << path.size() << " " << flag << endl;
        //  }
        if(root==NULL || flag ==1){
            return;
        }
        if(root->val == p->val){
            path.push_back(root);
            flag =1;
            return;
        }
        
        path.push_back(root); //adding 6
        helper(root->left, p, path, flag);
        if(path[path.size()-1]->val == p->val){  //if(flag==0){ wrong as popping 6 even when going to null node case
           return;
        }
        helper(root->right,p, path, flag);
        if(path[path.size()-1]->val == p->val){  
           return;
        }
        path.pop_back(); //removing 6 // backtracking
    }
};




//method 2-
//TC -O(n)
//SC -O(n)
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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        if(root==NULL || root==p || root ==q){
            return root;
        }
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right= lowestCommonAncestor(root->right, p , q);
        if(left != NULL && right != NULL){
            return root;
        }
        else if(left != NULL){
            return left;
        }
        else if(right != NULL){
            return right;
        }
        else{
            return NULL;
        }
    }
};