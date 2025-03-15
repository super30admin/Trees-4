// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public:
        int count = 0;
        int result = 0;
        void inorder(TreeNode* root){
            if(root == NULL) return;
            inorder(root->left);
            count--;
            if(count == 0) result = root->val;
            inorder(root->right);
        }
        int kthSmallest(TreeNode* root, int k) {
            count = k;
            inorder(root);
            return result;
        }
    };


// Int based function
class Solution {
    public:
        int count = 0;
        int inorder(TreeNode* root){
            if(root == NULL) return -1;
            int left = inorder(root->left);
            if(left != -1) return left;
            count--;
            if(count == 0){
                return root->val;
                
            } 
            return inorder(root->right);
        }
        int kthSmallest(TreeNode* root, int k) {
            count = k;
            return inorder(root);
        
        }
    };

// Iterative approach


class Solution {
    public:
        int kthSmallest(TreeNode* root, int k) {
            stack<TreeNode*> st;
            while(!st.empty() || root != NULL){
                while(root != NULL){
                    st.push(root);
                    root=root->left;
                }
                root = st.top();
                st.pop();
                k--;
                if(k==0) return root->val;
                root = root->right;
            }
            return -1;
        
        }
    };