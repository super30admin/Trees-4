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
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null ){
            return node;
        }
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        
        if(left==null && right==null){
            if(p.val == node.val || q.val == node.val){
                return node;
            }else{
                return null;
            }
        }else if(left==null && right!=null){
            if(p.val == node.val || q.val == node.val){
                return node;
            }else{
                return right;
            }
        }else if(left!=null && right==null){
            if(p.val == node.val || q.val == node.val){
                return node;
            }else{
                return left;
            }
        }else{
            return node;
        }
    }
}
