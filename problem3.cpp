/*
// Time Complexity : O(logN)
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
tracing the path of each node 
And then comparing the path and sending the previous node to the node where the output differs.
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

//dfs base approach

class Solution {
    vector<TreeNode*> path_p{};
    vector<TreeNode*> path_q{};
    vector<TreeNode*> temp{};

    void dfs(TreeNode* curr,TreeNode* p,TreeNode* q){
        //base
        if(curr == NULL) return;
        temp.push_back(curr);
        if(curr->val == p->val){
            vector<TreeNode*> sol{temp};
            sol.push_back(curr);
            path_p = sol;
        }
        else if(curr->val == q->val){
            vector<TreeNode*> sol{temp};
            sol.push_back(curr);
            path_q = sol;
        }
        //logic
        if(path_p.size() == 0 || path_q.size() == 0) dfs(curr->left,p,q);
        if(path_p.size() == 0 || path_q.size() == 0) dfs(curr->right,p,q);
        temp.pop_back();
    }

    TreeNode* search(vector<TreeNode*> path_p,vector<TreeNode*> path_q){
        int p_size = path_p.size();
        int q_size = path_q.size();
        if(p_size>q_size) return search(path_q,path_p);
        int i{};
        for(;i<p_size;++i){
            if(path_p.at(i)->val == path_q.at(i)->val) continue;
            return path_p.at(i-1);
        }
        return path_p.at(i-1);
    }

public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        dfs(root,p,q);
        return search(path_p,path_q);
    }
};

//top down recursion

/*
Time Complexity : O(logN);
Space Complexity : O(logN); '//stack

Your return to your parent if the given nodes exist or not 
if both exist as a child to the given root then return the root as the last common path
Else only one exist then send that child
Eventually the node where they diverged it will track back to that where it will say that it lie in their left and right subtree
Hence that node will be the answer.
*/

class Solution {

public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL || root->val == p->val || root->val == q->val) return root;
        
        TreeNode* left = lowestCommonAncestor(root->left,p,q);
        TreeNode* right = lowestCommonAncestor(root->right,p,q);

        if(left && right) return root;
        if(left) return left;
        return right;
    }
};