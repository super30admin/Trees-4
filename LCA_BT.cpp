
class Solution {
public:
    vector<TreeNode*> path1;
    vector<TreeNode*> path2;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* result = NULL;
        getPath(root,p,path1);
        getPath(root,q,path2);
        for ( int i =0; i < path1.size(); i++){
            if ( path1[i] != path2[i]){
                return path1[i-1];
            }
        }
        return result;
    }
    
    void getPath(TreeNode* root, TreeNode* p, vector<TreeNode*>& path){
        
        if ( root == NULL) return;
        if ( root == p){
            path.push_back(p);
            path.push_back(p);
            return;
        }
        path.push_back(root);
        getPath(root->left, p, path);
        
        getPath(root->right, p, path);
        if ( p == path[path.size()-1]){
            return;
        }
        path.pop_back();    
    }
};