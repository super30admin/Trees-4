//Leetcode :  230. Kth Smallest Element in a BST
//Time Complexity: O(n), n is no of nodes in the tree
//Space Complexity: O(n) 

class Solution {
    int result;
    int n;
    public int kthSmallest(TreeNode root, int k) {
        result=-1;
        n=k;
        helper(root);
        return result;
    }
    public void helper(TreeNode root){
        if(root==null) return ;      
        helper(root.left);
        n--;
       if(n==0){
            result=root.val;
            return;
        }
        helper(root.right);
    }
}