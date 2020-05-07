//Time Complexity : O(n)
//Space Complexity : O(h)

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
        if(root == null){
            return null;
        }else if(root == p || root == q){
            return root;
        }else{
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left!=null && right !=null) return root;
            else if(left == null && right == null) return null;
            else return left!=null?left : right;
        }
        
    }
}