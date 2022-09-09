//TC : O(log(n))
//SC : O(1)
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
/*class Solution {
    PriorityQueue<TreeNode> pq;
    public int kthSmallest(TreeNode root, int k) {
        pq = new PriorityQueue<>((a,b)->(b.val-a.val));
        helper(root,k);
        return pq.poll().val;
    }
    
    private void helper(TreeNode root, int k){
        if(root==null) return;
        pq.add(root);
        if(pq.size() > k){
            pq.poll();
        }
        helper(root.left,k);
        helper(root.right,k);
    }
}*/
class Solution {
    int cnt;
    int result;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
       cnt =0;
       flag=false;
        inorder(root,k);
        return result;
    }
    
    private void inorder(TreeNode root, int k){
        if(root == null) return;
        if(!flag)inorder(root.left,k);
        cnt++;
        if(cnt==k){
            flag=true;
            result = root.val;
            return;
        }
        if(!flag)inorder(root.right,k);
    }
}
