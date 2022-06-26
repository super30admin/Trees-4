// Time Complexity :O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
public class KSmallestEleBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }
   private int count;
   private int result;
   public int kthSmallest(TreeNode root, int k) {
       this.count = k;
       this.result = -1;
       helper(root);
       return result;
   }
   
   private void helper(TreeNode root){
       if(root == null || result != -1) return;
       helper(root.left);
       count--;
       if(count == 0){
           result = root.val;
           return;
       }
       helper(root.right);
   }
}