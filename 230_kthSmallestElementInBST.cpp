// Time Complexity : O(H+K) where H is the height of the tree and K is the Kth smallest element
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int cnt=0;
    int result=0;
    int kthSmallest(TreeNode* root, int k) {
        if(root == NULL)
            return -1;
        result = -1;
        inorder(root, k);
        return result;
    }
    
    void inorder(TreeNode* root, int k){
        //base
        if(root == NULL)
            return;
            
        //logic
        inorder(root->left, k);
        if(++cnt == k)
            result = root->val;
        inorder(root->right, k);
    }
    
};


class Solution {
public:
    int cnt=0;
    int result=0;
    int kthSmallest(TreeNode* root, int k) {
        if(root == NULL)
            return -1;
        stack<TreeNode*> s;
        while(root != NULL || !s.empty()){
            while(root != NULL){
                s.push(root);
                root = root->left;
            }
            root = s.top();
            s.pop();
            k--;
            if(k == 0)
                return root->val;
            root = root->right;
        }
        return -1;
    }
    
};
