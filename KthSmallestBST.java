// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are traversing across all the nodes in the tree in worst case scenario
//Space Complexity: O(1) since we are not taking any extra space

 class Solution {
    
    private int count = 0, result;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return result;
     
        Helper(root, k);
        return result;
    }
    
    public void Helper(TreeNode root, int k){
        //Base Case        
        if(root == null) return;
                
        Helper(root.left, k);
        count++;
        if(count == k){
          result = root.val;  
          return;
        } 
        Helper(root.right, k);
    }
}