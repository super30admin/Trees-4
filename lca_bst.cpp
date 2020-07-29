// Time Complexity : O(logn)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Recursive solution
//1. Check for 4 basic conditions and recurse till the values are found.
class Solution {
public:
    TreeNode* result;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        //edge
        if(root==NULL || p==NULL|| q==NULL) return NULL;
        
        //logic
        if((root->val<p->val && root->val>q->val) || (root->val>p->val && root->val<q->val)){
            return root;
        }else if(root->val==p->val || root->val==q->val){
            return root;
        }else if(root->val>p->val && root->val>q->val){
            result = lowestCommonAncestor(root->left,p,q);
        }else if(root->val<p->val && root->val<q->val){
            result =lowestCommonAncestor(root->right,p,q);
        }
        
        return result;
    }
};

// Time Complexity : O(logn)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Iterative with stack solution
//1. Check for 4 basic conditions and iterate till the values are found.
class Solution {
public:
    TreeNode* result;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        //edge
        if(root==NULL || p==NULL|| q==NULL) return NULL;
        
        //logic
        stack<TreeNode*> st;
        st.push(root);
        while(!st.empty() || root!=NULL){
            while(root !=NULL){
                if((root->val<p->val && root->val>q->val) || (root->val>p->val && root->val<q->val)){
                    return root;
                }else if(root->val==p->val || root->val==q->val){
                    return root;
                }else if(root->val<p->val && root->val<q->val){
                    break;
                }
                root = root->left;
                if(root !=NULL) st.push(root);
            }
            st.pop();
            root = root->right;
        }
        return NULL;
    }
};


// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Iterative without stack solution
//1. Check for 4 basic conditions and iterate till the values are found.
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        //edge
        if(root==NULL || p==NULL|| q==NULL) return NULL;
        
        //logic
        while(root!=NULL){
            if(root->val<p->val && root->val<q->val){
                root = root->right;
            }else if(root->val>p->val && root->val>q->val){
                root = root->left;
            } else return root;
        }
        
        return NULL;
    }
};
