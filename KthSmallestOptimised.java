/*
Time Complexity : O(k)
Space Complexity : O(k)-> If recursive stack space considered.
 Did it run on LeetCode : Yes.
 Any problems : No.
*/

class Solution {
    int count =0;
    int result=0;
    public int kthSmallest(TreeNode root, int k) {
         dfs( root, k);
        return result;
    } 
    private void dfs(TreeNode root, int k)
    {
        if(root==null) return ;
        dfs(root.left,k);
            count++;
            if(k==count)
                result=(root.val); 
        dfs(root.right,k);
    }
}
