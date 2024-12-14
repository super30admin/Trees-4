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
    int res;
    boolean flag= false;
    List<TreeNode> path = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        System.out.println(path.size());
        return res;
        
    }
    
    private void helper(TreeNode root,int k ) {
        // inorder traversal is always sorted.
        // base
        if(root== null || flag) {
            return;
        }
        
        // logic
        helper(root.left, k);
        path.add(root);
        if(path.size()==k) {
            res = path.get(path.size()-1).val;
            flag = true;
            return;
        }
        helper(root.right, k);
        return;
    }
}