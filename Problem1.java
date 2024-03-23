/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Accepted on LT
class Solution {
    int count = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {

        int x = helper(root,k);
        return result;
        
    }
    public int helper(TreeNode root, int k){
        if(root==null) return 0 ;

        helper(root.left,k);
        count = count+1;
        if(count==k){
            System.out.println(count);
            System.out.println(root.val);
            result=root.val;
        }
        helper(root.right,k);
        System.out.println(count);
        

        return -1;


    }
}