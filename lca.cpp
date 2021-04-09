TC:O(N) where N is the no of nodes in the tree
SC: O(N)


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
        unordered_map<TreeNode*,TreeNode*>parent;
        queue<TreeNode*>qu;
        if(root == nullptr)return root;
        parent[root]=nullptr;
        qu.push(root);
        while(parent.find(p)==parent.end() || parent.find(q)==parent.end()){
            root = qu.front();qu.pop();
            
            if(root->left){
                qu.push(root->left);
                parent[root->left] = root;
            }
            if(root->right){
                qu.push(root->right);
                parent[root->right] = root;
            }
        }
        
        unordered_map<TreeNode*,bool>p_ancestors;
        while(p){
            p_ancestors[p] = true;
            p = parent[p];
        }
        while(p_ancestors.find(q)==p_ancestors.end()){
            q = parent[q];
        }
        return q;
        
    }
};