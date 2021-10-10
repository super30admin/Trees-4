// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
Using DFS and property of BST ( all smallest element be on left side)
so if we traverse bst in LRootRight fashion and keep adding it in an arraylist then items in arraylist be in ascending order so now element at k-1 location be the kth smallest element of BST
Note:same way if we want to get kth largest elment in bst then simple traverse tree in RightRootLeft fashion
*/



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
class Solution {
    int kthElement ;
    List<Integer> arr ;
    public int kthSmallest(TreeNode root, int k) {
        kthElement = Integer.MAX_VALUE;
        arr = new ArrayList<>();
           List<Integer> arrn  = arr;
        dfs(root,k);
        
        return arr.get(k-1);
    }
    
    private void dfs(TreeNode root, int k)
    {
        if (root == null)
            return;
       
       
        dfs(root.left,k);
         arr.add(root.val);
        dfs(root.right,k);
        
       
       
    }
}