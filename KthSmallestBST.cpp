// Time Complexity - O(n)
// Space Complexity - O(1)
// Problems Faced - No!
// It runs on Leetcode - Yes!
class Solution {
    int count;
    int answer;
    private:
    void inorder(TreeNode* root, int i){
        // base
        if(root == NULL)
            return;
        
        // logic
        inorder(root->left, i);
        count++;
        if(count == i){
            answer = root->val;
            return;
            }
        inorder(root->right, i);
    }
public:
    int kthSmallest(TreeNode* root, int k) {
        inorder(root, k);
        return answer;
    }
};