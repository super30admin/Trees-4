// Problem - LCA of BT
//  Time Complexity : O(n)
//  Space Complexity : O(h) - h is height of the tree
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. If both left and right return non-null return root
// 2. If left returns null return right, right returns null return left
// 3. This way we don't need to actually visit the nodes, if one of the sides
// returns null

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
  TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {
    if (!root || root->val == p->val || root->val == q->val) {
      return root;
    }
    auto l = lowestCommonAncestor(root->left, p, q);
    auto r = lowestCommonAncestor(root->right, p, q);
    if (l && r) {
      return root;
    } else if (!l) {
      return r;
    } else {
      return l;
    }
  }
};
