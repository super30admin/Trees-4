// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class KthSmallestElementBST {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        int temp = 0;
        for (int i =0;i < k;i++){
            temp = pq.poll();
        }
        return temp;        
    }

    private void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        pq.add(root.val);
    }
}
