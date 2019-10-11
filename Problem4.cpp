/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
230. Kth Smallest Element in a BST
671. Second Minimum Node In a Binary Tree
Easy

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:

Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.

 

Example 2:

Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.


 * Solution 1: using Inorder traversal
   Time Complexity : O(n)
 * Space complexity :O(1)
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    
    int min,min2; /* min is 1st smallest, min2 is 2nd smallest */

    void inorder(TreeNode* root) {
        if (root == NULL) {
            return;
        }
        inorder(root->left);
        /* If min is not yet found, or a new min is found then update min2 to min and min */
        if (min == -1 || min > root->val) {
            min2 = min;
            min = root->val;
        } else {
            /* If we got a higher value than current min, see if its smaller than min2 so that min2 can also be updated */
            if (min < root->val) {
                if (min2 == -1) {
                    min2 = root->val;
                } else if (min2 > root->val) {
                    min2 = root->val;
                }
            }
        }
        inorder(root->right);
    }
    
    
    int findSecondMinimumValue(TreeNode* root) {
        min = -1;
        min2 = -1;
        inorder(root);
        return min2;
        
    }
};
/* Execute on leetcode platform */


