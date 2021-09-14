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
 Time Complexity = O(h+n)
 Space Complexity = O(h) 
 where h is the height of the tree and n is the number of nodes in the tree.
 */
class Solution {
public:
    int ans=0;
    int count;
    void dfs(TreeNode* root, int k){
        //base
        if(root==NULL)
            return;
        //logic
        dfs(root->left,k);
        count++;
        if(count==k)
            ans = root->val;
        if(!ans)
            dfs(root->right,k);    
    }
    int kthSmallest(TreeNode* root, int k) {
        count=0;
        dfs(root,k);
        return ans;
    }
};


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
 Time Complexity = O(h+n)
 Space Complexity = O(h) 
 where h is the height of the tree and n is the number of nodes in the tree.
 */
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        stack<TreeNode*> s;
        int ans;
        while(root!=NULL || !s.empty()){
            while(root!=NULL){
                s.push(root);
                root=root->left;
            }
            k--;
            root = s.top();
            s.pop();
            if(k==0)
                return root->val;
            root=root->right;
        }
        return ans;
    }
};
