#include <iostream>
#include <vector>
#include <algorithm>
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
        TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
            TreeNode* ptr = root;
            if(q->val<p->val) swap(p,q);
            while(ptr){
                if(ptr->val > q->val){
                    ptr = ptr->left;
                }
                else if(ptr->val<p->val){
                    ptr = ptr->right;
                }
                else return ptr;
            }
            return NULL;
        }
};
int main() {
    Solution solution;
    TreeNode* root = new TreeNode(6);
    root->left = new TreeNode(2);
    root->right = new TreeNode(8);
    root->left->left = new TreeNode(0);
    root->left->right = new TreeNode(4);
    root->left->right->left = new TreeNode(3);
    root->left->right->right = new TreeNode(5);
    root->right->left = new TreeNode(7);
    root->right->right = new TreeNode(9);
    TreeNode* p = root->left; // Node with value 2
    TreeNode* q = root->right; // Node with value 8
    TreeNode* result = solution.lowestCommonAncestor(root, p, q);
    if (result) {
        cout << "Lowest Common Ancestor: " << result->val << endl; // Output: 6
    } else {
        cout << "Lowest Common Ancestor not found." << endl;
    }
    return 0;
}
// Time Complexity: O(h) where h is the height of the tree
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No
// Your code here along with comments explaining your approach in three sentences only
// Leveraged the properties of the BST to navigate from the root to the lowest common ancestor (LCA). If both p and q are less than the current node, moved left; if both are greater, moved right. When one is on each side, found the LCA.