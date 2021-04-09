
TC: O(N)
SC: max height of the tree




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
        //inorder traversal
        stack<TreeNode*>st;
        while(!st.empty()||root!=NULL){
            if(root){
                st.push(root);
                root = root->left;
            }
            else{
                root = st.top();st.pop();
                k--;
                if(k==0)return root->val;
                root = root->right;
            }
        }
        return -1;
        
        
    }
};



///Using priority queue
/*
    int kthSmallest(TreeNode* root, int k) {
        priority_queue<int>pq;
        //level order traversal;
        queue<TreeNode*>q;
        if(root==nullptr)return -1;
        q.push(root);
        while(!q.empty()){
            root = q.front();q.pop();
            if(pq.size()<k)pq.push(root->val);
            else{
                if(pq.top()>root->val){
                    pq.pop();
                    pq.push(root->val);
                }
            }
            if(root->left)q.push(root->left);
            if(root->right)q.push(root->right);
            
        }
        return pq.top();
        
    }
*/