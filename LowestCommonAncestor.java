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
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(right==null){
            return left;
        }
        if(left==null){
            return right;
        }
        
        return root;
    }

}

//Time complexity : O(N) in worst case we visit all the nodes
//Space complexity : O(N) in worst case height of tree can be N so O(N) else O(h)
