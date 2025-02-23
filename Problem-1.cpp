/*
TC : O(n)
SC : O(H)
*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution
{
public:
    int answer;
    int cnt;
    int kthSmallest(TreeNode *root, int k)
    {
        if (root == nullptr)
        {
            return -1;
        }
        answer = -1;
        cnt = k;
        dfs(root);
        return answer;
    }

    void dfs(TreeNode *root)
    {
        // base
        // if node val is null or answer is found
        if (root == nullptr || answer != -1)
        {
            return;
        }

        // logic
        dfs(root->left);
        // if the kth element is found return
        cnt--;
        if (cnt == 0)
        {
            answer = root->val;
            return;
        }
        dfs(root->right);
    }
};