/**
 * @Time complexity:
 * O(N) where N is the number of nodes.
 * Both recursive and iterative solution will have 
 * O(N)
 * 
 */

/**
 * @Space Complexity:
 * Recursive: O(N) where N is the number of nodes
 * Iterative: O(1)
 * 
 */

/**
 * @Approach:
 * We know in binary search tree, left subtree has values smaller
 * than root and right subtree has values greater than root.
 * So, if the given p and q values are smaller than the root
 * we explore the left subtree. Otherwise, we explore the right subtree.
 * In other cases like where one value is greater than root and one 
 * smaller or where root itself is one of the given values, the root
 * will itself be the lowest common ancestor.
 */

//The code ran perfectly on leetcode

//Rercursive Solution
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(p->val > root->val && q->val > root->val){
            return lowestCommonAncestor(root->right, p, q);
        } else if( p->val < root->val && q->val < root->val){
            return lowestCommonAncestor(root->left, p, q);
        } else {
            return root;
        }
    }
};

//Iterative Soloution
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        while(true){
            if(p->val > root->val && q->val > root->val)  root = root->right;
            else if( p->val < root->val && q->val < root->val)  root = root->left;
            else return root;
        } 
    }
};