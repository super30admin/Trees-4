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
    List<Integer> in_order;
    public int kthSmallest(TreeNode root, int k) {
        in_order = new ArrayList<>();
        in_order_trav(root);
        int i = 0;
        while(k > 0){
           // in_order.get(i);
            k --;
            i++;
        }
        return in_order.get(i - 1);
    }

    public void in_order_trav(TreeNode root){

        if(root == null){
            return;
        }

        //left call
        in_order_trav(root.left);
        in_order.add(root.val);
        in_order_trav(root.right);

        
    }


}