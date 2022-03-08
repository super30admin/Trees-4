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
 * We need to find the kth smallest element. So we can use inorder
 * traversal because it gives us the elements in the ascending order.
 * 
 * We are keeping a global count to keep the track of k.
 * So first we need to hit the NUll on the left subtree and after that
 * we decrease the count by 1 and then again check the value of count if
 * it is zero or not if it becomes zero then the current root will be our answer
 * Otherwise we need to check the right subtree too.
 * 
 * Based on this approach we can get our result.
 * 
 */

// The code ran perfectly on leetcode

class Solution {
    
    int count;
    TreeNode* result;
public:
    int kthSmallest(TreeNode* root, int k) {
        if(root == NULL) return -1;
        count = k;
        inorder(root);
        return result->val;
    }
    
    private:
    void inorder(TreeNode* root){
        //base
        if(root == NULL) return;
        
        //logic
        if(result==NULL){
            inorder(root->left);
        }
        count--;
        if(count==0){
            result = root;
            return;
        }
        
        if(result == NULL){
            inorder(root->right);
        }
        
        
    }
};