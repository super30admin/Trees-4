#include<iostream>
#include<stack>
#include<vector>
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
        void findKthSmallest(TreeNode* root, TreeNode*& ptr, int& counter, int k){
            if(!root) return;
            findKthSmallest(root->left, ptr,counter,k);
            counter++;
            if(counter==k){
                ptr = root;
                return;
            }
            findKthSmallest(root->right, ptr, counter, k);
        }
        int kthSmallest(TreeNode* root, int k) {
            int counter = 0;
            TreeNode* val;
            findKthSmallest(root, val, counter, k);
            return val->val;
        }
};
int main() {
    Solution solution;
    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(1);
    root->right = new TreeNode(4);
    root->left->right = new TreeNode(2);
    int k = 1;
    int result = solution.kthSmallest(root, k);
    cout << "K-th smallest element: " << result << endl; // Output: 1
    return 0;
}
// Time Complexity: O(h+k) where h is the height of the tree and k is the kth smallest element
// Space Complexity: O(h) for the recursion stack in the worst case, where h is the height of the tree
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No
// Your code here along with comments explaining your approach in three sentences only
// Performed an inorder traversal of the BST, which visits nodes in ascending order. Maintained a counter to track the number of nodes visited and stopped when the counter reached k, storing the k-th smallest node's value.