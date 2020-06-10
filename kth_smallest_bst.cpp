//Time Complexity-O(nlogn) //Not sure can you confirm?
//Space Complexity=O(h+k) i.e. recursive stack and queue
//Ran successfully on leetcode

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
        if(root==NULL)
            return -1;
        priority_queue<int,vector<int>,greater<int>>pq;
        dfs(root,pq,k);
        while(k>1)
        {
            pq.pop();
            k--;
        }
        return pq.top();
    }
    void dfs(TreeNode* root,priority_queue<int,vector<int>,greater<int>>&pq,int k)
    {
        if(root==NULL)
            return;
        pq.push(root->val);
        dfs(root->left,pq,k);
        
        dfs(root->right,pq,k);
    }
};