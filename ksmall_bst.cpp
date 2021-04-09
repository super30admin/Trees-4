//TC: O(n) where n is the number of nodes in the tree
//SC: O(1)

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        
        TreeNode *curr = root;
        stack<TreeNode*> s;
        
        int ksmall = -1;
        
        //Done using iterative inorder traversal since in inorder traversal, the nodes are in ascending order
        
        while(curr!=NULL || !s.empty()){
            
            while(curr!=NULL){
                s.push(curr);
                curr = curr->left;
            }
            
            curr = s.top();
            s.pop();
            
            ksmall = curr->val;
            k--;
            if(k == 0){
                break;
            }
            
            curr = curr->right;
        }
        
        return ksmall;
        
    }
};