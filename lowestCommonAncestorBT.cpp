// Approach 1 : Recursive Top Down

// Time Complexity : O(n) internal stack uses space = height of tree 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No - time level exceeded


// Approach 2 : Recursive Bottom up

// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Approach 1 : Recursive Top Down

/*

As we traverse the tree, we mantain a path with all the nodes we travelled to reach that ndoe
when we found the node p or q, save the path in 2 variables

Ex: pathP = 3 5 
    pathQ = 3 5 4

Now the solution is the last number in this array which was the same
To make computation easy, add the last element or p twice to the path - that way the comparison will deifnitely fail without going out of bound

Ex: pathP = 3 5 5
    pathQ = 3 5 4 4

Note: C++ does not pass by reference, it passes by value. Thus we do not have to un-do the action every time

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
    vector<TreeNode*> pathP;
    vector<TreeNode*> pathQ;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root==NULL) return NULL;
        dfs(root, p, q, vector<TreeNode*>());
        
        int i=0, j=0;
        while(pathP[i] == pathQ[j]){
            i++;
            j++;
        }
        return pathP[i-1];
    }

    void dfs (TreeNode* root, TreeNode* p, TreeNode* q, vector<TreeNode*> path) {
        if(root == NULL) return;

        // adding this node to the path
        path.push_back(root);

        // add the node again in the end for easy computation
        // if we found p, store the path until now to pathP
        // we might return to this step in the recursion, and we do not want the extra root
        // so reove it
        if(root == p){
            path.push_back(root);
            pathP = path;
            path.pop_back();
        }
        else if(root == q) {
            path.push_back(root);
            pathQ = path;
            path.pop_back();
        }

        // recursively call dfs on left and right
        dfs(root->left, p, q, path);
        dfs(root->right, p, q, path);        
    }
};


// Approach 2: Bottom up

/*
Trickle up the root when we find p or q - null otherwise 

every node will trikle have either null or p or q coming from left and right child 

1. If both left and right are null, return null
2. If one of them have a treeNode, return that i.e., thats either p or q
3. If left returns one node and right returns another, then root is the answer. Return that 
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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root==NULL) return NULL;
        TreeNode* result = dfs(root, p, q);
        return result;
    }

    TreeNode* dfs (TreeNode* root, TreeNode* p, TreeNode* q) {
        // trickle up the found node or null
        if (root == NULL || root == p || root == q) {
            return root;
        }
        //right holds the solution from right sub-tree and left from left-sub tree
        TreeNode* right = dfs(root->right, p, q);
        TreeNode* left = dfs(root->left, p, q);

        // if both are null, the following conditions take care of it
        // or return the non-null solution
        if(right == NULL){
            return left;
        }
        if (left == NULL) {
            return right;
        }
        // if neither are not null, the root itself is the answer
        return root;
    }
};