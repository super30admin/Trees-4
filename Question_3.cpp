#include <iostream>
#include <vector>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
class Solution {
    public:
        bool hasAnyNode(TreeNode* root, TreeNode* p, TreeNode* q, TreeNode*& ptr){
            if(!root) return false;
            bool leftSubTree = hasAnyNode(root->left,p,q,ptr);
            bool rightSubTree = hasAnyNode(root->right,p,q,ptr);
            bool currentNode = (root->val==p->val)||(root->val==q->val);
            if(leftSubTree+rightSubTree+currentNode>=2) ptr = root;
            return leftSubTree||rightSubTree||currentNode;
    
        }
        TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
            TreeNode* lca;
            hasAnyNode(root,p,q,lca);
            return lca;
        }
};
int main() {
    Solution solution;
    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(5);
    root->right = new TreeNode(1);
    root->left->left = new TreeNode(6);
    root->left->right = new TreeNode(2);
    root->left->right->left = new TreeNode(7);
    root->left->right->right = new TreeNode(4);
    root->right->left = new TreeNode(0);
    root->right->right = new TreeNode(8);
    TreeNode* p = root->left; // Node with value 5
    TreeNode* q = root->right; // Node with value 1
    TreeNode* result = solution.lowestCommonAncestor(root, p, q);
    if (result) {
        cout << "Lowest Common Ancestor: " << result->val << endl; // Output: 3
    } else {
        cout << "Lowest Common Ancestor not found." << endl;
    }
    return 0;
}
// Time Complexity: O(n) where n is the number of nodes in the tree
// Space Complexity: O(h) for the recursion stack in the worst case, where h is the height of the tree
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No
// Your code here along with comments explaining your approach in three sentences only
// Performed a post-order traversal of the binary tree, checking if each subtree contains either of the target nodes (p or q). If a node is found to be the common ancestor (i.e., both target nodes are found in its subtrees or one is the node itself), stored it as the lowest common ancestor. Returned the lowest common ancestor after the traversal.