// Approach - DFS
// Time Complexity - O(n)
// Space Complexity -  O(2h)
// Problems Faced - It gives me Memory Limit Exceeded
// It runs on Leetcode - No - It gives me Memory Limit Exceeded.
class Solution {
    vector<TreeNode*> pathP;
    vector<TreeNode*> pathQ;
    private:
    void dfs(TreeNode* root, TreeNode* p, TreeNode* q, vector<TreeNode*> path){
        // base
        if(root == NULL)
            return;
        
        // logic
        //action
        path.push_back(root);
        if(root == p){
            pathP = path;
            pathP.push_back(p);
        }
        if(root == q){
            pathQ = path;
            pathQ.push_back(q);
        }
        // recursion
        dfs(root->left, p, q, path);
        dfs(root->right, p, q, path);
        
        // backtrack
        path.pop_back();
    }
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> path;
        dfs(root, p, q, path);
        for(int i = 0; i < pathP.size(); i++){
            if(pathP[i] != pathQ[i])
                return pathP[i-1];
        }
        return NULL;
    }
};

// Approach - Bottom-Up Approach
// Time Complexity - O(n)
// Space Complexity - O(1)
// Problems Faced - No!
// It runs on Leetcode - Yes!
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL || root == p || root == q)
            return root;
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        if(!left && !right)
            return NULL;
        else if(!left && right)
            return right;
        else if(!right && left)
            return left;
        else
            return root;
    }
};