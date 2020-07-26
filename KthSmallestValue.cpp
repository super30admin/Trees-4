// Time Complexity : O(N) where N=Number of nodes
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//This solution uses Inorder traversal to find the kth smallest value. 

class Solution {
public:
    int result,count;
    int kthSmallest(TreeNode* root, int k) {
        //Iterative Solution
        
        // stack<TreeNode*> st;
        // TreeNode* curr = root;
        // while(!st.empty() || root!=NULL){
        //     if(curr!=NULL){
        //         st.push(curr);
        //         curr = curr->left;
        //     }
        //     else{
        //         curr = st.top();
        //         st.pop();
        //         k--;
        //         if(k==0){
        //             return curr->val;
        //         }
        //         curr = curr->right;
        //         } 
        //     }   
        // return -1;  
        //Recursive Solution
        count = k;
        helper(root);
        return result;
    }
    
    void helper(TreeNode* curr){
        if(curr==NULL) return;
        helper(curr->left);
        count--;
        if(count==0){
            result = curr->val;
        }
        helper(curr->right);
    }
};
