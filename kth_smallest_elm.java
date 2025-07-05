//Time complexity -> O(n)
// Space Complexity -> O(n)
class Solution {
    int element = -1;
    int kth;
    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        helper(root);
        return element;
    }

    public void helper(TreeNode root){
        // base case
        if(root == null || element != -1) return;
        
        // logic 
        helper(root.left);
        kth--;
        if(kth == 0){
            element = root.val;
            return;
        }
        helper(root.right);
    }
}
