//Time Complexity-O(n)-->'n' is number of nodes
//Space Complexity-O(1) if recursive stack space is not considered or else it is O(h)-->'h' is height of Binary tree
//Did the code run on Leetcode? Yes

class Solution {
public:
    TreeNode* res=NULL;
    bool lowest(TreeNode* root,TreeNode* p,TreeNode* q)
    {
        if(root==NULL)
        {
            return 0;
        }
        int mid=(root->val==p->val|| root->val==q->val)?1:0;
        int left=lowest(root->left,p,q);
        int right=lowest(root->right,p,q);
        if( mid+left+right>=2)
        {
            res=root;
        }
        return mid+left+right>0;
        
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        lowest(root,p,q);
        return res;
    }
};