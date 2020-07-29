// Time Complexity : O(2n+k) //k-comparision of two arrays
// Space Complexity : O(2h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Brute force method of running with extra space for storage
// Your code here along with comments explaining your approach
//1. Find each element
//2. Node all the parent nodes of the element including the element.
//3. Find the common node.

class Solution {
public:
    bool found=false;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        //edge
        if(root==NULL ||p==NULL||q==NULL) return NULL;
        
        //logic
        vector<TreeNode*> p_vec;
        vector<TreeNode*> q_vec;
        
        dfs(root, p, p_vec);
        found=false;
        dfs(root, q, q_vec);
        TreeNode* temp = new TreeNode(INT_MIN);
        while(p_vec.size() > q_vec.size()){
            q_vec.insert(q_vec.begin(),temp);
        }
        while(p_vec.size() < q_vec.size()){
            p_vec.insert(p_vec.begin(),temp);
        }
        int i=0;
        
        while(i<p_vec.size() && i<q_vec.size()){
            if(p_vec[i]->val == q_vec[i]->val) return p_vec[i];
            i++;
        }
        return NULL;
    }
    
    void  dfs(TreeNode* root, TreeNode* s,vector<TreeNode*> & s_vec){
        //return
        if(root==NULL || found== true) return;
        
        //logic
        if(found==false && root->val==s->val){
            found =true;
            s_vec.push_back(root);
            return;
        }
        dfs(root->left, s, s_vec);
        dfs(root->right, s, s_vec);
        if(found == true){
            s_vec.push_back(root);
        }
    }
};

// Time Complexity : O(n) //k-comparision of two arrays
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Brute force method of running with extra space for storage
// Your code here along with comments explaining your approach
//1. Find each element and return true when found
//2. Check at the parent node of the element including the element for both left and right branches returning true.

class Solution {
public:
    TreeNode* result=NULL;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        //edge
        if(root==NULL ||p==NULL||q==NULL) return NULL;
        //logic
        dfs(root, p, q);
        return result;
    }
    
    bool  dfs(TreeNode* root,TreeNode* val1, TreeNode* val2) {
        //return condition
        if(root==NULL)
            return false;
        
        bool found_at_node = false;
        bool left_found = dfs(root->left, val1, val2);
        bool right_found = dfs(root->right, val1, val2);
        
        if (root->val == val1->val || root->val == val2->val) {
            found_at_node = true;
        }
        
        if (left_found  && right_found) {
            result = root;
        }
        
        if (found_at_node && (left_found || right_found)) {
            result = root;
        }
        return found_at_node || left_found || right_found;
    }
};
