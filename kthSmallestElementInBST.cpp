//time complexity:O((nlogn)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using recursion & priority queue
//any issues faced? no

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
    priority_queue<int,vector<int>,greater<int>>pq;
    int kthSmallest(TreeNode* root, int k) {
        dfs(root);
        int res=0;
        while(k--)
        {
            res=pq.top();
            pq.pop();
        }
        return res;
    }
    void dfs(TreeNode* root)
    {
        if(root==NULL)
            return;
        dfs(root->left);
        pq.push(root->val);
        dfs(root->right);
    }
};