//using priority queue 
//Time Complexity-O(n)-->'n' is number of nodes
//Space Complexity-O(k)-->'k' is queue size
//Did the code execute on Leetcode? Yes

class Solution {
public:
    void small(TreeNode* root, int &k,priority_queue<int,vector<int>>&m)
    {
        if(root==NULL)
        {
            return;
        }
        if(k!=0)
        {
            m.push(root->val);
            k--;
        }
        else
        {
            if(root->val<m.top())
            {
                m.pop();
                m.push(root->val);
            }
        }
        if(root->left==NULL && root->right==NULL)
        {
            return;
        }
        small(root->left,k,m);
        small(root->right,k,m);
        
    }
    
    int kthSmallest(TreeNode* root, int k) {
        priority_queue<int,vector<int>>m;
        small(root,k,m);
        return m.top();
    }
};