/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 Time Complexity = O(N)
 Space Complexity = O(h)
 where n is the height of the tree and h is the height of the tree.
 */
class Solution {
public:
    vector<TreeNode*> ppath;
    vector<TreeNode*> qpath;
    void backtrack(TreeNode* root, TreeNode* p, TreeNode* q,vector<TreeNode*>&path){
        //base
        if(root==NULL)
            return;
        if(root==p){
            ppath.assign(path.begin(), path.end());
            ppath.push_back(p);
            ppath.push_back(p);
        }
        //logic
        if(root==q){
            qpath.assign(path.begin(), path.end());
            qpath.push_back(q);
            qpath.push_back(q);
        }
        //action
        path.push_back(root);
        
        //recurse
        backtrack(root->left,p,q,path);
        if(ppath.size()==0 || qpath.size()==0)
            backtrack(root->right,p,q,path);
        
        //backtrack
        path.pop_back();
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> path;
        backtrack(root,p,q,path);
        int i=0;
        TreeNode* ans;
        while(i<ppath.size() && i<qpath.size())
        {
            if(ppath[i]!=qpath[i])
                return ppath[i-1];
                
            i++;
        }
        return NULL;
    }
};

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
  Time Complexity = O(N)
 Space Complexity = O(h)
 where n is the height of the tree and h is the height of the tree.
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root==NULL || root==p || root==q)
            return root;
        TreeNode* left = lowestCommonAncestor(root->left,p,q);
        TreeNode* right =lowestCommonAncestor(root->right,p,q);
        
        if(left!=NULL && right!=NULL)
            return root;
        else if(left!=NULL)
            return left;
        else if(right!=NULL)
            return right;
        else return NULL;
    }
};
