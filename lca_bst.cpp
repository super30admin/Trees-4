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

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Backtracking solution


class Solution {
public:
    vector<TreeNode*> p_node;
    vector<TreeNode*> q_node;
    bool p_found = false;
    bool q_found = false;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        //edge
        if(root==NULL)
            return NULL;
        if(p==NULL && q!=NULL){
            return q;
        } else if(p !=NULL && q==NULL){
            return p;
        }
        
        //logic
        vector<TreeNode*> list;
        back_track( root,  p,  q, list);
        
        // for(auto i: p_node){
        //        cout<<i->val<<"\t";
        // }
        // cout<<"\n";
        // for(auto i: q_node){
        //        cout<<i->val<<"\t";
        // }
        
        int p_ptr=0, q_ptr=0;
        for(p_ptr=p_node.size()-1; p_ptr>=0; p_ptr--){
            for(q_ptr=0; q_ptr<q_node.size(); q_ptr++){
               if(p_node[p_ptr]->val == q_node[q_ptr]->val){
                    return p_node[p_ptr];
                }   
            }
        }
        return NULL;
    }
    
    void back_track( TreeNode* root, TreeNode* p, TreeNode* q, vector<TreeNode*> &list){
        if(root==NULL || (p_found ==true && q_found== true)){
            return;
        }
        
         //action
        list.push_back(root);
        
        if(root->val == p->val){
            p_found = true;
            for(auto i: list){
                p_node.push_back(i);
            }
        } else if(root->val == q->val){
            q_found = true;
            for(auto i: list){
                q_node.push_back(i);
            }
        }
        
        //recurse
        back_track( root->left,  p,  q, list);
        back_track( root->right,  p,  q, list);
        
        //backtrack
        list.pop_back();
    }
};
