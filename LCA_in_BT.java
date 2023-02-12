/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //TreeNode result = LCAHelper();
        
        if(root == null){
            return null;
        }
        
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
        TreeNode value1 = lowestCommonAncestor(root.left, p, q);
        TreeNode value2 = lowestCommonAncestor(root.right, p, q);
        TreeNode result = null;
        if(value1 != null && value2 != null){
            result =  root;
        }
        
        if(value1 == null){
            result = value2;
        }
        
        if(value2 == null){
            result = value1;
        }
        
        return result;
    }
}