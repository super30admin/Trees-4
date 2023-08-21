// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * 1. Do inorder traversal and add to list.
 * 2. Return kth element from list.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        dfs(root,result,k);
        
        return result.get(k-1);
    }
    
    private void dfs(TreeNode root,List<Integer> result,int k){
        if(root==null || result.size()==k){
            return;
        }
        
        dfs(root.left,result,k);
        result.add(root.val);
        dfs(root.right,result,k);
    }
}