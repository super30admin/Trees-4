// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : The space complexity if O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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

        return LCA(root,p,q);

    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){

        if(root == null){
            return null;
        }

        TreeNode left = LCA(root.left,p,q);
        TreeNode right = LCA(root.right,p,q);

        // If p and q are found in different directions
        if(left != null && right != null){
            return root;
        }

        if(root == p || root == q){
            return root;
        }

        // p or q is found
        if(left != null){return left;}
        if(right != null){return right;}

        return null;
    }
}
