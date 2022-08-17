//Time Complexity- O(n)
//Space Complexity- O(h)
//Sucessfully ran on leetcode
class Solution {
 TreeNode first, second;
 TreeNode prev;
 public void recoverTree(TreeNode root) {
     if(root == null) return ;
     inorder(root);
     
     int temp= first.val;
     first.val= second.val;
     second.val= temp;
     
 }
 private void inorder(TreeNode root){
     
     //base
     if(root == null) return;
     //logic
     inorder(root.left);
     
     if(prev!= null && prev.val>= root.val){
         if(first== null){
             first = prev;
             second= root;
         }
         else second= root;
     }
     prev= root;
     
     inorder(root.right);
 }
}
