230. Kth Smallest Element in a BST

//BFS min priority queue
// TC O(n)
// SC O(k)
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        // priority_queue<int,greater<int>> pq;
        if(root==NULL)
        {
            return 0;
        }
       priority_queue <int, vector<int>, greater<int>> gp;
       queue<TreeNode*> q;
       q.push(root);

       while(q.size()>0)
       {
           int s=q.size();

           while(s--)
           {
               TreeNode* tmp=q.front();
               q.pop();
               gp.push(tmp->val);
                   if(tmp->left)
                   {
                       q.push(tmp->left);
                   }

                   if(tmp->right)
                   {
                       q.push(tmp->right);
                   }
           }
       }

k=k-1;
       while(k--)
       {

           gp.pop();
       }
       int ans=gp.top();
       return ans;

    }
};
