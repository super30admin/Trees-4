/*
// Time Complexity : O(logN)
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
find 1st element
find 2nd element
find the last common element
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
    
    vector<TreeNode*> search(TreeNode* node,TreeNode* find){
        vector<TreeNode*> path{};
        TreeNode* curr{node};
        while(curr->val!=find->val){
            path.push_back(curr);
            if(curr->val>find->val) curr = curr->left;
            else curr = curr->right;
        }
        path.push_back(curr);
        return path;
    }

    TreeNode* lca(vector<TreeNode*>& path_p,vector<TreeNode*>& path_q){
        int p_size = path_p.size();
        int q_size = path_q.size();
        if(p_size>q_size) return lca(path_q,path_p);
        int i{};
        for(;i<p_size;i++){
            if(path_p.at(i)->val==path_q.at(i)->val) continue;
            else break;
        }
        return path_p.at(i-1);
    }
    
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {

        TreeNode* curr{root};
        vector<TreeNode*> path_p = search(root,p);
        vector<TreeNode*> path_q = search(root,q);
        return lca(path_p,path_q);

    }
};

// another solution

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL || root->val == p->val || root->val == q->val) return root;
        else if(root->val > p->val && root->val >q->val) return lowestCommonAncestor(root->left,p,q);
        else if(root->val<p->val && root->val < q->val) return lowestCommonAncestor(root->right,p,q);
        else return root;

    }
};

// good optimised solution

// Space Complexity: O(logN) //height of the stack, but better than the previous one.

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {

        if(root == NULL || root -> val == p -> val || root -> val == q -> val) return root;

        TreeNode* left = lowestCommonAncestor(root -> left, p, q);
        TreeNode* right = lowestCommonAncestor(root -> right, p, q);

        if(left && right) return root;
        if(left) return left;
        return right;
    }
};