"""
Intuition: 
#####################################################################
Solution 1:Get all the elements in a list. Return the k-1 element
Time Complexity : O(N) 
Space Complexity : O(H)
#####################################################################
Solution 2:Create a count, if count == k, that is the result
Time Complexity : O(N) 
Space Complexity : O(H)
#####################################################################
Solution 3:Same as solution 2, but iterative
Time Complexity : O(N) 
Space Complexity : O(H)
#####################################################################
Solution 4:Slight modification by decrementing k.
Time Complexity : O(N) 
Space Complexity : O(H)
#####################################################################
"""

class Solution {
public:
    vector<int> elements;
    int kthSmallest(TreeNode* root, int k) {
        helper(root);
        return elements[k-1];
    }
    
    void helper(TreeNode* root){
        if ( root == NULL){
            return;
        }
        helper(root->left);
        elements.push_back(root->val);
        helper(root->right);
        
    }
};

class Solution {
public:
    int result=-1, count =0;
    int kthSmallest(TreeNode* root, int k) {
        helper(root,k);
        return result;
    }
    
    void helper(TreeNode* root, int k){
        if ( root == NULL){
            return;
        }
        helper(root->left ,k);
        count++;
        if(count == k) result = root->val;
        helper(root->right,k);
        
    }
};



class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        int count = 0;
        stack<TreeNode*> stack;
        while ( root != NULL or stack.size() !=0){ 
            while ( root != NULL){
                stack.push(root);
                root = root->left;
            }
            root = stack.top();
            stack.pop();
            count ++;
            if ( k == count){
                return root->val;
            }
            root = root->right;
        }
        return -1;
    }
    
};


class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        int count = 0;
        stack<TreeNode*> stack;
        while ( root != NULL or stack.size() !=0){ 
            while ( root != NULL){
                stack.push(root);
                root = root->left;
            }
            root = stack.top();
            stack.pop();
            k--;
            if ( k == 0){
                return root->val;
            }
            root = root->right;
        }
        return -1;
    }
    
};