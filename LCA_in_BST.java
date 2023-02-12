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
        //make use of the bst proprty.

        return dfs(root, p, q);

    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){


        if(root == null){
            return null;
        }

        if(((p.val <= root.val) && q.val >= root.val) || ((q.val <= root.val) && p.val >= root.val)){
            return root;
        }

        //if both the nodes are greater than the current root then go to the right side of root. 

        if((p.val > root.val) && (q.val > root.val)){
            return dfs(root.right, p, q);
        }

        return dfs(root.left, p, q);
    }
}