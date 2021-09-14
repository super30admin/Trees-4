// Time Complexity : O(N) where N is number of nodes.
// Space Complexity :O(H) where H is the height of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<TreeNode*> path1;
    vector<TreeNode*> path2;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL)
            return root;
        vector<TreeNode*> path;
        backtrack(root, p, q, path);
        for(int i=0; i<path1.size(); i++){
            if(path1[i] != path2[i])
                return path1[i-1];
        }
        return NULL;
    }
    
    void backtrack(TreeNode* root, TreeNode* p, TreeNode* q, vector<TreeNode*>& path){
        //base
        if(root == NULL)
            return;
        if(root == p){
            path1.assign(path.begin(), path.end());
            path1.push_back(p);
            path1.push_back(p);
        }
        if(root == q){
            path2.assign(path.begin(), path.end());
            path2.push_back(q);
            path2.push_back(q);
        }
        //logic
        //action
        path.push_back(root);
        //recurse
        backtrack(root->left, p, q, path);
        if(path1.size() == 0 || path2.size() == 0)
            backtrack(root->right, p, q, path);
        //backtrack
        path.pop_back();
    }
};


// Time Complexity : O(N) where N is number of nodes.
// Space Complexity :O(H) where H is the height of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL || root == p || root == q)
            return root;
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        if(left != NULL && right != NULL)
            return root;
        else if(left != NULL)
            return left;
        else if(right != NULL)
            return right;
        else
            return NULL;
    }
};
