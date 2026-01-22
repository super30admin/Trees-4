// Problem - Kth smallest element in BST
//  Time Complexity : O(n)
//  Space Complexity : O(h) (stack space worst case O(n) for skewed tree)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We use iterative inorder traversal here to traverse the tree
// 2. We decrement the k and once k is zero we know we have reached the kth
// smallest node, and we return the value

#include <iostream>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};

class Solution {
public:
  int kthSmallest(TreeNode *root, int k) {
    stack<TreeNode *> st;
    st.push(root);
    while (!st.empty() || root != nullptr) {
      while (root) {
        st.push(root);
        root = root->left;
      }
      root = st.top();
      st.pop();
      k--;
      if (k == 0) {
        return root->val;
      }
      root = root->right;
    }
    return 1;
  }
};
