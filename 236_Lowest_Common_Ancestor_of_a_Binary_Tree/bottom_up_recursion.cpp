#include<bits/stdc++.h>
using namespace std;

/*
Approach: Bottom up recursion: We search if P OR Q exist in L or R subarr. If both return non NULL then current is LCA. If one return non NULL then forward that up as this might be the LCA. Similar for right. If curr is P OR Q then return current
Time: O(n)
Space: O(h) .. recursive stack
Works on leetcode: Yes
*/

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        return postorder(root, p, q);
    }

    TreeNode* postorder(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == nullptr || root == p || root == q) {
            return root;
        }

        TreeNode* leftRes = postorder(root->left, p, q);
        TreeNode* rightRes = postorder(root->right, p, q);
        if(leftRes != nullptr && rightRes != nullptr) {
            return root;
        }
        else if(leftRes != nullptr) {
            return leftRes;
        }
        else {
            return rightRes;
        }
    }
};