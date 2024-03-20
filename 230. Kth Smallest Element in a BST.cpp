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

/*
Time: O(n)
Space: O(logn) (recursive stack space)

Approach: In an in/preorder traversal of BST,
A node has values greater than all nodes traversed before it + the nodes in its left subtree
For every node, check if it is greater than k-1 nodes or not!
*/

class Solution {
public:
    int ans = 0;
    int k;

    //param traversed : no. of already traversed nodes (these nodes have values smaller than current node)
    int call(TreeNode* node, int traversed){
      if(node==nullptr)  return 0;

      int left_sz = call(node->left, traversed);

      int smaller_than_current = traversed + left_sz;
      if(smaller_than_current + 1 == k)  ans = node->val; //kth node found!

      int right_sz = call(node->right, smaller_than_current + 1); //+1 for this node itself
      
      return left_sz + right_sz + 1;
    }

    int kthSmallest(TreeNode* root, int k) {
        this->k = k;
        call(root, 0);
        return ans;
    }
};
