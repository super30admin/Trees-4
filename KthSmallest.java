//Time Complexity: O(n)
//Space Complexity:(h)
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
    PriorityQueue<Integer> pq;
    public int kthSmallest(TreeNode root, int k) {
        pq=new PriorityQueue<>((a,b)->b-a);
        dfs(root,k);
        return pq.peek();
    }
    private void dfs(TreeNode root,int k){
        if(root==null)
            return;
        pq.add(root.val);
        System.out.println("Added"+root.val);
        if(pq.size()==k+1){
            System.out.println("Removed"+ pq.poll());
            // pq.poll();
            
        }
        dfs(root.left,k);
        dfs(root.right,k);
    
    }
}
