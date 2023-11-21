
// Time Complexity :O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
  int result;
  int count;
    public int kthSmallest(TreeNode root, int k) {
      count = k;
      dfs(root);
      return result;
    }
    
    public void dfs(TreeNode root){
        //base condition
        if(root == null) return;
        
       
        //action
        if(count != 0) dfs(root.left);
        count --;
        if(count == 0){
        result = root.val;
        return;
        }
        
        //recurse
       if(count != 0) { dfs(root.right);
         

        
    }
    
}
