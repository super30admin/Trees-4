// Time Complexity : o(k)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        count =k;
        result =-1;
        dfs(root);
        
        return result;
    }
    private void dfs(TreeNode root){
        if(root==null) return;
        
        if(result==-1){
            dfs(root.left);
        }
         count--;
        if(count==0){
            result = root.val;   
            return;
        }
        
        if(result==-1){
            dfs(root.right);
        }
    }
}