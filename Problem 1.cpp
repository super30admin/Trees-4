//Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    //using iterative solution
    int kthSmallest(TreeNode* root, int k) {
        stack<TreeNode*> st;
        while(root!=NULL || st.empty()==false){
            while(root!=NULL){
                st.push(root);
                root = root->left;
            }
            root = st.top();
            st.pop();
             k--;
            
            if(k==0)
                return root->val;
            root = root->right;
        }
        
        return -1;
        
    }
};