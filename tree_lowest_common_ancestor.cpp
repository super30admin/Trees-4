// Time Complexity : O(n)
// Space Complexity :  O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
private:
    // Vectors to keep track of Path of nodes from root
    vector<TreeNode*> p_q;
    vector<TreeNode*> q_q;
    
    // Traverse node p
    bool trav_p(TreeNode* root, TreeNode* p)
    {
        // Null node
        if(root == NULL)
            return false;

        // Append the node to the vector
        p_q.push_back(root);
        
        // Found the node
        if(root == p)
            return true;
        
        // Traverse left subtree
        if(trav_p(root->left, p) == true)
            return true;
        
        // Traverse right subtree
        if(trav_p(root->right, p) == true)
            return true;

        // Remove the last node while going back up one level   
        p_q.pop_back();
        
        return false;
    }
    
    // Traverse node q
    bool trav_q(TreeNode* root, TreeNode* q)
    {
        // Null node
        if(root == NULL)
            return false;

        // Append the node to the vector
        q_q.push_back(root);
        
        // Found the node
        if(root == q)
            return true;
        
        // Traverse left subtree
        if(trav_q(root->left, q) == true)
            return true;
        
        // Traverse right subtree
        if(trav_q(root->right, q) == true)
            return true;

        // Remove the last node while going back up one level   
        q_q.pop_back();
        
        return false;
    }
    
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        if(!root)
            return root;

        // Traverse the node p and q      
        trav_p(root, p);
        trav_q(root, q);
        
        // The paths from root to nodes p and q ready in vectors

        TreeNode* lca = root;

        // Traverse through the vector
        // Till the lowest common ancestor is found        
        while(p_q[0]->val == q_q[0]->val)
        {
            lca = p_q[0];
            
            p_q.erase(p_q.begin());
            q_q.erase(q_q.begin());
        }      
        return lca; 
    }
};