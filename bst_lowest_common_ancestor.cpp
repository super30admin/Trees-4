// Time Complexity : O(logn)
// Space Complexity :  O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
private:
    // Queues for p, q to track the path from root node
    queue<TreeNode*> p_q;
    queue<TreeNode*> q_q;
    
    // Traverse till the p node
    void trav_p(TreeNode* root, TreeNode* p)
    {
        // Null root 
        if(root == NULL)
            return;

        // Push the node in queue
        p_q.push(root);
        
        // Stop if node found
        if(root == p)
            return;
        
        // Traverse left or right subtree
        if(root->val > p->val)
           trav_p(root->left, p); 
        else
            trav_p(root->right, p);
    }
    
    // Traverse till q node
    void trav_q(TreeNode* root, TreeNode* q)
    {
        // Null root
        if(root == NULL)
            return;

        // Push the node in queue
        q_q.push(root);
        
        // Stop if node found
        if(root == q)
            return;
        
        // Traverse left or right subtree
        if(root->val > q->val)
           trav_q(root->left, q); 
        else
            trav_q(root->right, q);
    }
    
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        if(!root)
            return root;

        // Traverse nodes p and q         
        trav_p(root, p);
        trav_q(root, q);
        
        TreeNode* lca = root;
        
        // Find the Lowest common ancestor from the Queue obtained from traversals
        while(p_q.front() == q_q.front())
        {
            lca = p_q.front();
            p_q.pop();
            q_q.pop();
        }
        return lca;
    }
};