//Time Complexity-O(logn)-->'n' is the number of nodes
//Space Complexity-O(h)-->'h' is the height of Tree
//Did the code execute on Leetcode? Yes

class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        if(root==NULL)
        {
            return 0;
        }
        int count=k;
        stack<TreeNode*>m;
        while(root!=NULL || !m.empty())
        {
            while(root!=NULL)
            {
                m.push(root);
                root=root->left;
            }
            root=m.top();
            m.pop();
            count--;
            if(count==0)
            {
                return root->val;
            }
            root=root->right;
        }
        return -1;
    }
};