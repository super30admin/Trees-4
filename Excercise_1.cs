// Time complexity Of solution is  O(N) Number od nodes worst case we will travsal all nodes 
// Space Complexity : O(1) I am not using any extra spave
//

public class Solution {
    int count = 0;
    TreeNode result ;
    public int KthSmallest(TreeNode root, int k) {
        
        bst(root,k);
        return result.val;
    }


    public void bst(TreeNode root,int k){
        if(root == null) return;
      if(result == null){
        bst(root.left,k);
      }
         count++;
         if(count == k) {result = root ;}
         if(result==null){
        bst(root.right,k);
         }
    }
}