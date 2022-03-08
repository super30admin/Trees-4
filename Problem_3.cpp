/**
 * @Time Complexity:
 * O(N) where N is the number of nodes in the tree
 * 
 */

/**
 * @Space Complexity:
 * O(N) where N is the number of nodes in the tree
 * 
 */

/**
 * @Approach:
 * Divide the problem according to cases like what if both the child are NULL,
 * what if one of the child is NULL and what if both are not NULL. Based on this intution
 * we traverse the tree. 
 * 
 * When root becomes equal to one of the given values, we then check the upper conditions
 * to get our result;
 * 
 */


//All the test cases passed BUT TLE

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        return helper(root,p,q);
     }


     private:
    TreeNode* helper(TreeNode* root, TreeNode* p, TreeNode* q){

         if(root == NULL || root == p || root == q) return root;

         TreeNode* left = helper(root->left,p,q);
         TreeNode* right = helper(root->right,p,q);

         if(left != NULL && right != NULL) return root;
         else if(left != NULL)   return left;
         else if(right != NULL)  return right;

         return NULL;
    }
};